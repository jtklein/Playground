package johannes.playground;

import android.os.Bundle;
import android.widget.Toast;

public class PgActivityLifecycle extends PgActivity {

    private int mOrder = 0;
    private String mStatus = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_lifecycle);

        mStatus = "onCreate";
        displayStatus();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mStatus = "onStart";
        displayStatus();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mStatus = "onRestoreInstanceState";
        displayStatus();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mStatus = "onResume";
        displayStatus();
    }

    @Override
    protected void onPause() {
        super.onPause();

        mStatus = "onPause";
        displayStatus();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mStatus = "onSaveInstanceState";
        displayStatus();
    }

    @Override
    protected void onStop() {
        super.onStop();

        mStatus = "onStop";
        displayStatus();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mStatus = "onDestroy";
        displayStatus();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mStatus = "onRestart";
        displayStatus();
    }

    private void displayStatus() {
        //Create String
        mOrder++;
        String toastText = String.valueOf(mOrder) + ") Activity is in: " + mStatus;

        // Display Toast
        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
    }
}
