package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by johannesklein on 10.11.16.
 */
public class PgActivityPersistance extends PgActivity {

    private Button mButtonSharedPreferences = null;
    private Button mButtonFiles = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_persistance);

        // The button to go to shared preferences
        mButtonSharedPreferences = (Button) findViewById(R.id.buttonSharedPreferences);
        mButtonSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(view.getContext(), PgActivitySharedPreferences.class);
                startActivity(intent);
            }
        });

        // The button to go to files
        mButtonFiles = (Button) findViewById(R.id.buttonFiles);
        mButtonFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(view.getContext(), PgActivityFiles.class);
                startActivity(intent);
            }
        });

    }
}
