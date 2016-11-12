package johannes.playground;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by johannesklein on 12.11.16.
 */
public class PgActivityNotification extends PgActivity {

    private Button mButton = null;
    private EditText mEditText = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_notification);

        mButton = (Button) findViewById(R.id.buttonNotification);

        mEditText = (EditText) findViewById(R.id.editTextPush);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = mEditText.getText().toString();

            }
        });

    }

}
