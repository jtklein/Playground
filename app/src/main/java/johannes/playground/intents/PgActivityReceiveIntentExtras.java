package johannes.playground.intents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import johannes.playground.PgActivity;
import johannes.playground.R;
import johannes.playground.intents.PgActivitySendIntentExtras;

/**
 * Created by johannesklein on 09.11.16.
 */
public class PgActivityReceiveIntentExtras extends PgActivity {

    private TextView mTextView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_receive_intent_extras);

        mTextView = (TextView) findViewById(R.id.textViewIntentExtraInt);

        // Get intent extras
        Bundle intentExtras = getIntent().getExtras();

        if (intentExtras != null){
            // Get the int from the extras and display
            int extraInt = intentExtras.getInt(PgActivitySendIntentExtras.KEY_FOR_INTENT_INT);
            mTextView.setText(String.valueOf(extraInt));

        }
    }
}
