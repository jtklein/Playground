package johannes.playground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class PgActivityLifecycle extends AppCompatActivity {

    int mOrder = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_lifecycle);

        displayStatus();
    }

    private void displayStatus() {
        //Create String
        mOrder++;
        String toastText = String.valueOf(mOrder) + ") Activity is in: " + "onCreate";

        // Display Toast
        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
    }
}
