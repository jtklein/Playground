package johannes.playground;

import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by johannesklein on 17.11.16.
 */
public class PgActivityResume extends PgActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.pg_activity_resume);
    }
}
