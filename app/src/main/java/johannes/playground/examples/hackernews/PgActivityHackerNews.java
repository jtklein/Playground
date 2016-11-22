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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_hacker_news);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBarHackerNews);
        mListView = (ListView) findViewById(R.id.listViewHackerNews);

        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mTitles);

        mListView.setAdapter(mAdapter);
    }
}
