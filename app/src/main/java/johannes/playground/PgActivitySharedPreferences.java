package johannes.playground;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by johannesklein on 11.11.16.
 */
public class PgActivitySharedPreferences extends AppCompatActivity{

    private TextView mTextView = null;
    private Button mButton = null;

    int timesRun = 0;
    private static final String NUMBER_TIMES_RUN = "NUMBER_TIMES_RUN";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_shared_preferences);

        mTextView = (TextView) findViewById(R.id.textViewSharedPreference);
        mButton = (Button) findViewById(R.id.buttonSavePreferences);

        // Get shared preferences
        final SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        timesRun = sharedPreferences.getInt(this.NUMBER_TIMES_RUN, 0);

        if (timesRun == 0){
            Toast.makeText(this, "Hit it man!", Toast.LENGTH_SHORT).show();
        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timesRun++;

                // Write to shared preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(NUMBER_TIMES_RUN, timesRun);
                editor.commit();

                mTextView.setText(String.valueOf(timesRun));
            }
        });

    }
}
