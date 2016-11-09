package johannes.playground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PgActivityIntents extends AppCompatActivity {

    private Button mButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_intents);

        mButton = (Button) findViewById(R.id.buttonImplicitIntents);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), PgActivityImplicitIntents.class);
                startActivity(intent);
            }
        });

    }
}
