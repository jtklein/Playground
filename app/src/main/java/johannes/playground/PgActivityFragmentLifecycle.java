package johannes.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by johannesklein on 11.11.16.
 */
public class PgActivityFragmentLifecycle extends PgActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_fragment_lifecycle);
    }
}
