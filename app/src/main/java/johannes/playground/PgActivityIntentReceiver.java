package johannes.playground;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

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
    }
}
