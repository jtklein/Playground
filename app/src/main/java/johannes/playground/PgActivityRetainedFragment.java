package johannes.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by johannesklein on 17.11.16.
 */
public class PgActivityRetainedFragment extends PgActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_retained_fragment);
    }
}
