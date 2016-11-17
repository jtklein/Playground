package johannes.playground;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by johannesklein on 17.11.16.
 */
public class PgActivityResume extends PgActivity {


    Button mButtonWorkHistory = null;
    Button mButtonCallJohannes = null;
    Button mButtonEMailJohannes = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_resume);


        mButtonWorkHistory = (Button) findViewById(R.id.buttonWorkHistory);
        mButtonCallJohannes = (Button) findViewById(R.id.buttonCallJohannes);
        mButtonEMailJohannes = (Button) findViewById(R.id.buttonEMailJohannes);

        mButtonWorkHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(getApplicationContext(), PgActivityWorkHistory.class);
                startActivity(intent);
            }
        });

        mButtonCallJohannes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get phone number from resources
                String stringPhoneNumber = getResources().getString(R.string.data_phone_number);
                Uri uriPhoneNumber = Uri.parse("tel:"+ stringPhoneNumber);

                // Implicit intent to call number
                Intent callIntent = new Intent(Intent.ACTION_DIAL, uriPhoneNumber);

                // Start intent if package available
                if (callIntent != null){
                    if (isIntentAvailable(callIntent)){
                        startActivity(callIntent);
                    } else {
                        // UX info that no package to start intent is available
                        Toast.makeText(view.getContext(), "Sorry no phone app available.", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        mButtonEMailJohannes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Implicit intent to email my address
                Intent eMailIntent = new Intent(Intent.ACTION_SEND);
                eMailIntent.setType("plain/text");

                // Add email address to intent extras
                String stringEmailAddress = getResources().getString(R.string.data_email_address);
                eMailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {stringEmailAddress});

                // Start intent if package available
                if (eMailIntent != null){
                    if (isIntentAvailable(eMailIntent)){
                        startActivity(eMailIntent);

                    } else {
                        // UX info that no package to start intent is available
                        Toast.makeText(view.getContext(), "Sorry no email app available.", Toast.LENGTH_SHORT).show();

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
