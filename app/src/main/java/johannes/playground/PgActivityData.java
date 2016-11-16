package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by johannesklein on 10.11.16.
 */
public class PgActivityData extends PgActivity{

    private Button mButtonParseJSON = null;
    private Button mButtonControlFlow = null;
    private Button mButtonNetworking = null;
    private Button mButtonMultithreading = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_data);

        // Go to parse JSON activity
        mButtonParseJSON = (Button) findViewById(R.id.buttonParseJSON);
        mButtonParseJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(view.getContext(), PgActivityParseJSON.class);
                startActivity(intent);
            }
        });

        // Go to controlflow activity
        mButtonControlFlow = (Button) findViewById(R.id.buttonControlFlow);
        mButtonControlFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(view.getContext(), PgActivityControlFlow.class);
                startActivity(intent);
            }
        });

        // Go to networking activity
        mButtonNetworking = (Button) findViewById(R.id.buttonNetworking);
        mButtonNetworking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(view.getContext(), PgActivityNetworking.class);
                startActivity(intent);
            }
        });

        // Go to multithreading activity
        mButtonMultithreading = (Button) findViewById(R.id.buttonMultithreading);
        mButtonMultithreading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple explicit intent
                Intent intent = new Intent(view.getContext(), PgActivityMultithreading.class);
                startActivity(intent);
            }
        });

    }
}
