package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by johannesklein on 09.11.16.
 */
public class PgActivityImplicitIntents extends AppCompatActivity {

    private Spinner mSpinner = null;
    private Button mButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_implicit_intents);

        mSpinner = (Spinner) findViewById(R.id.spinnerImplicitIntents);

        mButton = (Button) findViewById(R.id.buttonStartImplicitIntents);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent implicitIntent = null;
                if (implicitIntent != null){
                    if (isIntentAvailable(implicitIntent)){
                        startActivity(implicitIntent);

                    } else {
                        // TODO UX

                    }
                }
            }
        });
    }

    public boolean isIntentAvailable(Intent intent){
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,0);
        boolean isIntentSafe = activities.size() > 0;
        return isIntentSafe;
    }
}
