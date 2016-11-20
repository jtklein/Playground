package johannes.playground.data.networking;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 21.11.16.
 */
public class PgActivityDownloadImage extends PgActivity {

    private ImageView mImageView = null;
    private Button mButton = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_download_image);

        mImageView = (ImageView) findViewById(R.id.imageViewDownloadImage);
        mButton = (Button) findViewById(R.id.buttonDownloadImage);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageDownloader task = new ImageDownloader();

                Bitmap myImage;

                try {
                    myImage = task.execute("https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png").get();
                    mImageView.setImageBitmap(myImage);

                } catch (Exception e) {
                    e.printStackTrace();

                }

            }
        });
    }

    private class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {

            URL url = null;
            HttpURLConnection connection = null;
            InputStream inputStream = null;

            try {
                url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                inputStream = connection.getInputStream();
                return BitmapFactory.decodeStream(inputStream);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {

                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
    }
}
