package johannes.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Spinner;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by johannesklein on 10.11.16.
 */
public class PgActivityParseJSON extends AppCompatActivity {

    private Spinner mSpinner = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_parse_json);

        // Get the spinner
        mSpinner = (Spinner) findViewById(R.id.spinnerParseJSON);

        String exampleJSON = getJSONFile();
    }

    public String getJSONFile(){

        String json = null;

        try {
            // Open an input stream
            InputStream inputStream = getResources().openRawResource(R.raw.example_json);
            int fileSize = 0;
            fileSize = inputStream.available();
            byte[] buffer = new byte[fileSize];
            inputStream.read(buffer);
            inputStream.close();

            json = new String (buffer,"UTF-8");

        } catch (IOException e) {
            Log.e(this.getClass().getSimpleName(), "Error opening example_json file");
            e.printStackTrace();
            //TODO UX
            return null;

        }

        return json;
    }
}
