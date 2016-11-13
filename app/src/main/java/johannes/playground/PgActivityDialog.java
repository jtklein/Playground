package johannes.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by johannesklein on 13.11.16.
 */
public class PgActivityDialog extends PgActivity {

    private Button mButton = null;
    private EditText mEditText = null;

    private Dialog mDialog = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_dialog);

        mEditText = (EditText) findViewById(R.id.editTextDialogMessage);

        mButton = (Button) findViewById(R.id.buttonBuildDialog);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = mEditText.getText().toString();
                buildDialog(message).show();
            }
        });

    }

    private Dialog buildDialog(String message) {

    }
}
