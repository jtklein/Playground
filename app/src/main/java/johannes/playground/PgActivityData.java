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
public class PgActivityData extends AppCompatActivity{

    private Button mButton = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_data);

        mButton = (Button) findViewById(R.id.buttonParseJSON);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(view.getContext(), PgActivityParseJSON.class);
                startActivity(intent);
            }
        });

    }
}
