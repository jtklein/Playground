package johannes.playground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

/**
 * Created by johannesklein on 09.11.16.
 */
public class PgActivityImplicitIntents extends AppCompatActivity {

    private Spinner mSpinner = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_implicit_intents);

        mSpinner = (Spinner) findViewById(R.id.spinnerImplicitIntents);
    }
}
