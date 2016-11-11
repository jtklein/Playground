package johannes.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by johannesklein on 10.11.16.
 */
public class PgActivityParseJSON extends PgActivity {

    private Spinner mSpinner = null;
    private Button mButton = null;

    private String mData[] = {};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_parse_json);

        // Get the spinner
        mSpinner = (Spinner) findViewById(R.id.spinnerParseJSON);
        mButton = (Button) findViewById(R.id.buttonParse);

        String exampleJSON = getJSONFile();

        try {
            JSONObject rootJSON = new JSONObject(exampleJSON);
            JSONObject secondJSON = rootJSON.getJSONObject("stuffinside");
            JSONArray batterJSON = secondJSON.getJSONArray("batter");

            mData = new String[batterJSON.length()];

            for (int i = 0; i < batterJSON.length(); i++){

                mData[i] = batterJSON.getJSONObject(i).getString("type");
            }

        } catch (JSONException e) {
            Log.e(this.getClass().getSimpleName(), "Error while JSON Parsing");
            e.printStackTrace();

        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, mData);
                mSpinner.setAdapter(adapter);
            }
        });
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
