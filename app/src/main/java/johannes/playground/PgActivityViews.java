package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by johannesklein on 09.11.16.
 */
public class PgActivityViews extends PgActivity {

    private Button mButtonListView = null;
    private Button mButtonFloatingActionButton = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_views);

        // Button to go to ListViewActivity
        mButtonListView = (Button) findViewById(R.id.buttonListView);
        mButtonListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple Explicit Intent
                Intent intent = new Intent(view.getContext(), PgActivityListView.class);
                startActivity(intent);
            }
        });

        // Button to go to floating action button activity
        mButtonFloatingActionButton = (Button) findViewById(R.id.buttonFAB);
        mButtonFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(view.getContext(), PgActivityFloatingActionButton.class);
                startActivity(intent);
            }
        });

    }
}
