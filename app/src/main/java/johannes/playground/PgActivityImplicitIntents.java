package johannes.playground;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by johannesklein on 09.11.16.
 */
public class PgActivityImplicitIntents extends PgActivity {

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
                int position = mSpinner.getSelectedItemPosition();
                Intent implicitIntent = null;

                switch (position){
                    case 0:
                        // open web browser
                        implicitIntent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://google.com"));
                        break;
                    case 1:
                        // make phone call
                        implicitIntent = new Intent(Intent.ACTION_DIAL,
                                Uri.parse("tel:(+012)3456789"));
                        break;
                    case 2:
                        // open map
                        implicitIntent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:45.2345, 20.2345"));
                        break;
                    case 3:
                        // take picture
                        implicitIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                        break;
                }

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
