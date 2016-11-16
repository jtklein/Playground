package johannes.playground;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        /*
                Multithreading the hard way.
                Opening a new thread on click of the button.
                Interacting with the UI thread from background.

                Problem: Activity reference can be destroyed during background work
         */

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
                Thread thread = new Thread(new DownloadImagesThread(mLoadingUrls[position]));

                // Start thread
                thread.start();

            }
        });
    }

    public boolean downloadImageUsingThreads(String url){

        boolean success = false;

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        File file = null;

        try {
            // Create new URL object that represents the url
            URL downloadUrl = new URL(url);

            // Open connection to url
            urlConnection = (HttpURLConnection) downloadUrl.openConnection();
            int statusCode = urlConnection.getResponseCode();
            if (statusCode != HttpURLConnection.HTTP_OK) {
                success = false;
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
                while ((read = inputStream.read(buffer)) != -1){
                    // Write file while reading
                    fileOutputStream.write(buffer, 0, read);
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

            // Set progress bar layout invisible
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLinearLayoutLoading.setVisibility(View.GONE);
                }
            });
        }

        return success;
    }

    /**
     * Opens a new background thread that downloads an image from url
     */
    private class DownloadImagesThread implements Runnable {

        private String url = null;

        public DownloadImagesThread(String url) {
            // Save param
            this.url = url;

        }

        @Override
        public void run() {

            // Set progress bar in layout to visible
            PgActivityMultithreading.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLinearLayoutLoading.setVisibility(View.VISIBLE);
                }
            });

            // Download image
            downloadImageUsingThreads(url);
        }
    }
}
