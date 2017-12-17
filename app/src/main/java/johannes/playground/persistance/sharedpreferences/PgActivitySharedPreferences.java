package johannes.playground.persistance.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 11.11.16.
 */
public class PgActivitySharedPreferences extends PgActivity {

    private TextView mTextView = null;
    private TextView mTextViewString = null;
    private Button mButton = null;

    int timesRun = 0;
    private static final String NUMBER_TIMES_RUN = "NUMBER_TIMES_RUN";

    private ArrayList<String> stringArray = null;
    private static final String STRING_ARRAY_KEY = "STRING_ARRAY_KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_shared_preferences);

        mTextView = (TextView) findViewById(R.id.textViewSharedPreference);
        mTextViewString = (TextView) findViewById(R.id.textViewStringSharedPreferences);
        mButton = (Button) findViewById(R.id.buttonSavePreferences);

        // Get shared preferences
        final SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        timesRun = sharedPreferences.getInt(this.NUMBER_TIMES_RUN, 0);
        String serializedArray = sharedPreferences.getString(this.STRING_ARRAY_KEY, "");

        // If run for the very first time
        if (timesRun == 0){
            // Init string array
            Toast.makeText(this, "Hit it man!", Toast.LENGTH_SHORT).show();
            stringArray = new ArrayList<String>();
        } else {
            // Deserialize shared preference string into an array
            try {
                stringArray = (ArrayList<String>) ObjectSerializer.deserialize(serializedArray);
            } catch (IOException e) {
                e.printStackTrace();
            }

            updateViews();
        }
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringArray.add(String.valueOf(timesRun));
                timesRun++;

                // Serialize array into a string
                String prefString = null;
                try {
                    prefString = ObjectSerializer.serialize(stringArray);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Write to shared preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(NUMBER_TIMES_RUN, timesRun);
                if (prefString != null){
                    editor.putString(STRING_ARRAY_KEY, prefString);
                }
                editor.apply();

                updateViews();
            }
        });
    }

    private void updateViews() {

        mTextView.setText(String.valueOf(timesRun));
        mTextViewString.setText(stringArray.toString());

    }
}
