package johannes.playground.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 11.11.16.
 */
public class PgActivityFragmentLifecycle extends PgActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_fragment_lifecycle);

        // Add the fragment to activity
        if (savedInstanceState == null){
            getFragmentManager().beginTransaction()
                    .add(R.id.containerExampleFragment, new PgFragmentLifecycle())
                    .commit();
        }

    }
}
