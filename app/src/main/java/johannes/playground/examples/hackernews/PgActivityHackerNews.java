package johannes.playground.examples.hackernews;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 22.11.16.
 */
public class PgActivityHackerNews extends PgActivity {

    private ProgressBar mProgressBar = null;
    private ListView mListView = null;

    private ArrayAdapter mAdapter = null;

    private ArrayList<String> mTitles = new ArrayList<String>();
    private ArrayList<String> mUrls = new ArrayList<String>();

    private SQLiteDatabase articlesDB = null;

    private static int numberItems = 20;

    private static String urlTopStories = "topstories";
    private static String urlItem = "item/";
    private static String queryString = ".json?print=pretty";

    private static String articleID = null;
    private static String articleTitle = null;
    private static String articleUrl = null;

    public static final String ITEM_URL_KEY = "ITEM_URL_KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_hacker_news);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBarHackerNews);
        mListView = (ListView) findViewById(R.id.listViewHackerNews);

        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mTitles);

        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), PgActivityHackerNewsWebview.class);
                intent.putExtra(ITEM_URL_KEY, mUrls.get(i));
                startActivity(intent);
            }
        });

        articlesDB = this.openOrCreateDatabase("articles", MODE_PRIVATE, null);

        articlesDB.execSQL("DROP TABLE articles");

        articlesDB.execSQL("CREATE TABLE IF NOT EXISTS articles " +
                "(id INTEGER PRIMARY KEY, articleID INTEGER, title VARCHAR, url VARCHAR)");

        // Make RESTful webservice call using AsyncHttpClient object
        String query = urlTopStories + queryString;
        Log.i(this.getClass().getSimpleName(), query);

        mProgressBar.setVisibility(View.VISIBLE);

        PgHackerNewsRestClient.get(urlTopStories + queryString, null, new DownloadTopStoriesHandler());

        updateListView();

    }

    public void updateListView(){

        Cursor c = articlesDB.rawQuery("SELECT * FROM articles", null);

        int titleIndex = c.getColumnIndex("title");
        int contentIndex = c.getColumnIndex("url");

        if (c.moveToFirst()){

            mTitles.clear();
            mUrls.clear();

            do {
                mTitles.add(c.getString(titleIndex));
                mUrls.add(c.getString(contentIndex));
            } while (c.moveToNext());

            mAdapter.notifyDataSetChanged();

        }
    }

    private class DownloadTopStoriesHandler extends JsonHttpResponseHandler {

        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
            // called when response HTTP status is "200 OK"
            JSONArray results = response;
            Log.i(this.getClass().getSimpleName(), response.toString());

            if (response.length() < 20) {
                numberItems = response.length();
            }

            articlesDB.execSQL("DELETE FROM articles");

            for (int i = 0; i < numberItems; i++) {
                try {
                    articleID = response.getString(i);
                    Log.i(this.getClass().getSimpleName(), articleID);

                    // Make RESTful webservice call using AsyncHttpClient object
                    String query = urlItem + articleID + queryString;
                    Log.i(this.getClass().getSimpleName(), query);
                    PgHackerNewsRestClient.get(query, null, new DownloadItemHandler());

                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }

            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }

    private class DownloadItemHandler extends JsonHttpResponseHandler {

        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

            JSONObject jsonObject = response;

            if (!jsonObject.isNull("title") && !jsonObject.isNull("url")) {
                try {
                    articleTitle = jsonObject.getString("title");
                    articleUrl = jsonObject.getString("url");
                    Log.i(this.getClass().getSimpleName(), articleTitle + " - " + articleUrl);

                    String sql = "INSERT INTO articles (articleID, title, url) VALUES (?, ?, ?)";

                    SQLiteStatement statement = articlesDB.compileStatement(sql);

                    statement.bindString(1, articleID);
                    statement.bindString(2, articleTitle);
                    statement.bindString(3, articleUrl);

                    statement.execute();

                    updateListView();

                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }

        }
    }
}
