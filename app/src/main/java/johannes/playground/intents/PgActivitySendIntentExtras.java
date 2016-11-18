package johannes.playground.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 09.11.16.
 */
public class PgActivitySendIntentExtras extends PgActivity {

    public static final String KEY_FOR_INTENT_INT = "KEY_FOR_INTENT_INT";

    private EditText mEditText = null;
    private Button mButton = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_send_intent_extras);

        mEditText = (EditText) findViewById(R.id.editTextSendIntentExtraInt);
        mButton = (Button) findViewById(R.id.buttonSendIntentExtraInt);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Make sure there is input
                if (mEditText.getText().length() > 0){
                    // Get the number from edit Text
                    int input = 0;
                    input =  Integer.valueOf(mEditText.getText().toString());

                    // Create intent for receiver activity with extra
                    Intent intent = new Intent(view.getContext(), PgActivityReceiveIntentExtras.class);
                    intent.putExtra(KEY_FOR_INTENT_INT, input);
                    startActivity(intent);
                } else {
                    //TODO UX
                }
            }
        });
    }
}
