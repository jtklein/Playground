package johannes.playground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PgActivityIntents extends PgActivity {

    private Button mButtonImplicitIntents = null;
    private Button mButtonIntentExtras = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_intents);

        // Button to go to implicit intents
        mButtonImplicitIntents = (Button) findViewById(R.id.buttonImplicitIntents);
        mButtonImplicitIntents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple intent to go to activity
                Intent intent = new Intent(view.getContext(), PgActivityImplicitIntents.class);
                startActivity(intent);
            }
        });

        // Button to go to intent extras
        mButtonIntentExtras = (Button) findViewById(R.id.buttonIntentExtras);
        mButtonIntentExtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple intent to go to activity
                Intent intent = new Intent(view.getContext(), PgActivitySendIntentExtras.class);
                startActivity(intent);
            }
        });




    }
}
