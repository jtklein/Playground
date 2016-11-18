package johannes.playground.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 12.11.16.
 */
public class PgActivityIntentRequest extends PgActivity {

    private TextView mTextView = null;
    private Button mButton = null;

    private static final int REQUEST_CODE = 1;
    public static final String REQUEST_RETURN_KEY = "REQUEST_RETURN_KEY";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_intent_request);

        mTextView = (TextView) findViewById(R.id.textViewRequestSelection);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE){

            if (resultCode == RESULT_CANCELED){

                Toast.makeText(this, "Selection canceled", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_OK){

                if (data.hasExtra(REQUEST_RETURN_KEY)){

                    String selection = data.getExtras().getString(REQUEST_RETURN_KEY);
                    mTextView.setText(selection);
                }
            }
        }
    }
}
