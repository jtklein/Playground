package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PgActivityActivities extends PgActivity {

    private Button mButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_activities);

        // Go to activity lifecycle
        mButton = (Button) findViewById(R.id.buttonActivityLifecycle);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple intent
                Intent intent = new Intent(view.getContext(), PgActivityLifecycle.class);
                startActivity(intent);
            }
        });
    }
}
