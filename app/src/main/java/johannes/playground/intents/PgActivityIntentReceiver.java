package johannes.playground.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 12.11.16.
 */
public class PgActivityIntentReceiver extends PgActivity {

    private TextView mTextView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_intent_receiver);

        mTextView = (TextView) findViewById(R.id.textViewInterception);

        /*
            The receiver set up in manifest
         */

        // Receive http intent
        Intent httpIntent = getIntent();
        String action = httpIntent.getAction();

        // Check if intent is of action view
        if (action != null && action.equals(Intent.ACTION_VIEW)){
            Uri data = httpIntent.getData();
            if (data != null){
                // UX react to intent
                mTextView.setText("Interception!");
            }
        }
    }
}
