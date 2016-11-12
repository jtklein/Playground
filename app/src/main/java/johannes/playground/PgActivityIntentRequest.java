package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by johannesklein on 12.11.16.
 */
public class PgActivityIntentRequest extends PgActivity {

    private Button mButton = null;

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_intent_request);

        mButton = (Button) findViewById(R.id.buttonRequest);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent intent = new Intent(view.getContext(), PgActivityIntentRequestSelection.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }
}
