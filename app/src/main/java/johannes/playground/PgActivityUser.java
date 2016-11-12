package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by johannesklein on 12.11.16.
 */
public class PgActivityUser extends PgActivity {

    private Button mButtonToast = null;
    private Button mButtonNotification = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_user);

        mButtonToast = (Button) findViewById(R.id.buttonToast);
        mButtonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(view.getContext(), PgActivityToast.class);
                startActivity(intent);
            }
        });

        mButtonNotification = (Button) findViewById(R.id.buttonNotification);
        mButtonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(view.getContext(), PgActivityNotification.class);
                startActivity(intent);
            }
        });
    }
}
