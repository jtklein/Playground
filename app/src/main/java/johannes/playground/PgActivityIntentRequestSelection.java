package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by johannesklein on 12.11.16.
 */
public class PgActivityIntentRequestSelection extends PgActivity {

    private Button mButton = null;
    private Spinner mSpinner = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_intent_request_selection);

        mButton = (Button) findViewById(R.id.buttonIntentRequestReturn);
        mSpinner = (Spinner) findViewById(R.id.spinnerRequestSelection);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PgActivityIntentRequest.class);
                intent.putExtra(PgActivityIntentRequest.REQUEST_RETURN_KEY, mSpinner.getSelectedItem().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
