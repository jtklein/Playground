package johannes.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

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


    }
}
