package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by johannesklein on 09.11.16.
 */
public class PgActivitySendIntentExtras extends AppCompatActivity {

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

                // Get the number from edit Text
                // TODO make sure there is input in EditText
                int input = 0;
                input =  Integer.valueOf(mEditText.getText().toString());

                // Create intent for receiver activity with extra
                Intent intent = new Intent(view.getContext(), PgActivityReceiveIntentExtras.class);
                intent.putExtra(KEY_FOR_INTENT_INT, input);
                startActivity(intent);

            }
        });
    }
}
