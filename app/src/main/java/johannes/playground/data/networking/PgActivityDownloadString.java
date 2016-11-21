package johannes.playground.data.networking;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 20.11.16.
 */
public class PgActivityDownloadString extends PgActivity {

    private ProgressBar mProgressBar = null;

    private static String url = "https://www.ecowebhosting.co.uk/";

    private static String mResult = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_download_string);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBarDownloadImage);

        DownloadStringAsyncTask task = new DownloadStringAsyncTask();

        task.execute(url);

    }

    public class DownloadStringAsyncTask extends AsyncTask<String, Integer, String>{

        private String result = "";
        private URL url = null;
        private HttpURLConnection connection = null;

        @Override
        protected void onPreExecute() {
            // Make progress layout visible
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = connection.getInputStream();

                InputStreamReader reader = new InputStreamReader(inputStream);

                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();

                }

                Log.i(this.getClass().getSimpleName(), result);
                return result;

            } catch (MalformedURLException e) {
                Log.e(this.getClass().getSimpleName(), "Error malformed ULR in loading String");
                e.printStackTrace();

            } catch (IOException e) {
                Log.e(this.getClass().getSimpleName(), "Error IO in loading String");
                e.printStackTrace();

            }

            return "Failed!";
        }

        @Override
        protected void onPostExecute(String aString) {
            // Make progress layout invisible
            mProgressBar.setVisibility(View.GONE);

            mResult = aString;

        }
    }
}
