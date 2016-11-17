package johannes.playground;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by johannesklein on 17.11.16.
 */
public class PgActivityResume extends PgActivity {


    Button mButtonWorkHistory = null;
    Button mButtonCallJohannes = null;
    Button mButtonEMailJohannes = null;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
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
                startActivity(callIntent);
            }
        });

        mButtonEMailJohannes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Implicit intent to email my address
                Intent eMailJohannesIntent = new Intent(Intent.ACTION_SEND);
                eMailJohannesIntent.setType("plain/text");

                // Add email address to intent extras
                String stringEmailAddress = getResources().getString(R.string.data_email_address);
                eMailJohannesIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {stringEmailAddress});

                // Start intent
                startActivity(eMailJohannesIntent);

            }
        });
    }
}
