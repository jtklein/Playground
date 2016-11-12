package johannes.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by johannesklein on 12.11.16.
 */
public class PgActivityToast extends PgActivity {

    private Button mButton = null;
    private Switch mSwitch = null;
    private EditText mEditText = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_toast);

        mButton = (Button) findViewById(R.id.buttonShowToast);

        mSwitch = (Switch) findViewById(R.id.switchToast);

        mEditText = (EditText) findViewById(R.id.editTextToast);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = mEditText.getText().toString();
                if (!mSwitch.isChecked()){

                    Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}
