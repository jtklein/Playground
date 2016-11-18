package johannes.playground.data;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import johannes.playground.PgActivity;
import johannes.playground.views.PgListViewExampleAdapter;
import johannes.playground.views.PgListViewExampleItem;
import johannes.playground.R;

/**
 * Created by johannesklein on 16.11.16.
 */
public class PgActivityMultithreading extends PgActivity {

    private Button mButton = null;
    private ProgressBar mProgressBar = null;
    private Spinner mSpinner = null;
    private ListView mListView = null;
    private LinearLayout mLinearLayoutLoading = null;

    private PgListViewExampleAdapter mAdapter;

    private String[] mLoadingText;
    private String[] mLoadingUrls;

    private PgListViewExampleItem[] mData = new PgListViewExampleItem[2];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_multithreading);

        // Get the layout elements
        mButton = (Button) findViewById(R.id.buttonImageDownload);
        mProgressBar = (ProgressBar) findViewById(R.id.loadingProgress);
        mSpinner = (Spinner) findViewById(R.id.spinnerLoadingText);
        mListView = (ListView) findViewById(R.id.loadingUrls);
        mLinearLayoutLoading = (LinearLayout) findViewById(R.id.loadingSection);

        // Get the data from res
        mLoadingText = getResources().getStringArray(R.array.loading_text);
        mLoadingUrls = getResources().getStringArray(R.array.loading_urls);

        // Accumulate data
        for (int i = 0; i < mData.length; i++){
            mData[i] = new PgListViewExampleItem(mLoadingText[i], mLoadingUrls[i], "Selection in Spinner");

        }

        // Set list view adapter
        mAdapter = new PgListViewExampleAdapter(this, R.layout.pg_listview_item, mData);
        if (mAdapter != null){
            mListView.setAdapter(mAdapter);
        }

        // Download selected image on background thread
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = mSpinner.getSelectedItemPosition();

                // Open a new thread
                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute(mLoadingUrls[position]);

            }
        });
    }

    private class MyAsyncTask extends AsyncTask <String, Integer, Boolean> {

        private int contentLength = -1;
        private int counter = 0;
        private int calculatedProgress = 0;

        @Override
        protected void onPreExecute() {
            // Make progress layout visible
            mLinearLayoutLoading.setVisibility(View.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            boolean success = false;
            String url = strings[0];

            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            FileOutputStream fileOutputStream = null;
            File file = null;

            try {
                // Create new URL object that represents the url
                URL downloadUrl = new URL(url);

                // Open connection to url
                urlConnection = (HttpURLConnection) downloadUrl.openConnection();
                contentLength = urlConnection.getContentLength();

                int statusCode = urlConnection.getResponseCode();
                if (statusCode != HttpURLConnection.HTTP_OK) {
                    Log.e(this.getClass().getSimpleName(), "HTTP connection unsuccesfull");
                }

                inputStream = urlConnection.getInputStream();

                if (inputStream != null) {
                    // Get folder name on sdcard
                    String folder = getExternalFilesDir(null).getAbsolutePath();

                    // Create file name from folder and url last path segment
                    Uri uri = Uri.parse(url);
                    String fileName = uri.getLastPathSegment();
                    file = new File(folder + "/" + fileName);

                    // Create file output stream
                    fileOutputStream = new FileOutputStream(file);

                    // Read image from url with determinate buffer
                    int read = -1;
                    byte[] buffer = new byte[1024];
                    while ((read = inputStream.read(buffer)) != -1) {
                        // Write file while reading
                        fileOutputStream.write(buffer, 0, read);

                        // Publish download progress
                        counter = counter + read;
                        publishProgress(counter);
                    }

                    success = true;

                }
            } catch (MalformedURLException e) {
                Log.e(this.getClass().getSimpleName(), "Error downloading image from " + url);
                e.printStackTrace();

            } catch (IOException e) {
                Log.e(this.getClass().getSimpleName(), "Error IO in url connection to: " + url);
                e.printStackTrace();

            } finally {
                // Close url connection
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }

                // Close input stream
                if (inputStream != null){
                    try {
                        inputStream.close();

                    } catch (IOException e) {
                        Log.e(this.getClass().getSimpleName(), "Error closing input stream");
                        e.printStackTrace();
                    }
                }

                // Close output stream
                if (fileOutputStream != null){
                    try {
                        fileOutputStream.close();

                    } catch (IOException e) {
                        Log.e(this.getClass().getSimpleName(), "Error IO closing output stream");
                        e.printStackTrace();
                    }
                }
            }

            return success;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // Get progress
            double progress = values[0].doubleValue();
            calculatedProgress = (int) (progress/contentLength * 100);

            // Update progress bar
            mProgressBar.setProgress(calculatedProgress);

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            // Make progress layout invisible
            mLinearLayoutLoading.setVisibility(View.GONE);

        }
    }
}
