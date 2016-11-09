package johannes.playground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PgActivityMain extends AppCompatActivity {

    private Button mButtonActivities = null;
    private Button mButtonIntents = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_main);

        // The button to go to activities playground
        mButtonActivities = (Button) findViewById(R.id.buttonActivities);
        mButtonActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple intent
                Intent intent = new Intent(view.getContext(), PgActivityActivities.class);
                startActivity(intent);
            }
        });

        // The button to go to intents playground
        mButtonIntents = (Button) findViewById(R.id.buttonIntents);
        mButtonIntents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(view.getContext(), PgActivityIntents.class);
                startActivity(intent);
            }
        });


    }
}
