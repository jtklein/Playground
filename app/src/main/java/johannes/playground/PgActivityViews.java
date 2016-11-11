package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by johannesklein on 09.11.16.
 */
public class PgActivityViews extends PgActivity {

    private Button mButton = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_views);

        mButton = (Button) findViewById(R.id.buttonListView);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple Explicit Intent
                Intent intent = new Intent(view.getContext(), PgActivityListView.class);
                startActivity(intent);
            }
        });

    }
}
