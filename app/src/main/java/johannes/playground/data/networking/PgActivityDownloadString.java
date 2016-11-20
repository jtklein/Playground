package johannes.playground.data.networking;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

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

    private static String url = "https://www.ecowebhosting.co.uk/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_download_string);

        DownloadStringAsyncTask task = new DownloadStringAsyncTask();

        String result = null;
        try {
            result = task.execute(url).get();

        } catch (InterruptedException e) {
            Log.e(this.getClass().getSimpleName(), "Error interruption in Async Loading of String");
            e.printStackTrace();

        } catch (ExecutionException e) {
            Log.e(this.getClass().getSimpleName(), "Error in executing Async loading of String");
            e.printStackTrace();
        }
    }

    public class DownloadStringAsyncTask extends AsyncTask<String, Void, String>{

        private String result = "";
        private URL url = null;
        private HttpURLConnection connection = null;

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
    }
}
