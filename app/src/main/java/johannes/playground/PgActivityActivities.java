package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PgActivityActivities extends PgActivity {

    private Button mButtonActivityLifecycle = null;
    private Button mButtonFragmentLifecycle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_activities);

        // Go to activity lifecycle
        mButtonActivityLifecycle = (Button) findViewById(R.id.buttonActivityLifecycle);
        mButtonActivityLifecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple intent
                Intent intent = new Intent(view.getContext(), PgActivityLifecycle.class);
                startActivity(intent);
            }
        });

        // Go to fragment lifecycle
        mButtonFragmentLifecycle = (Button) findViewById(R.id.buttonFragmentLifecycle);
        mButtonFragmentLifecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(view.getContext(), PgActivityFragmentLifecycle.class);
                startActivity(intent);
            }
        });

    }
}
