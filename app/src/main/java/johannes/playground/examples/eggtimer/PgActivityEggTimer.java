package johannes.playground.examples.eggtimer;

import android.os.Bundle;
import android.support.annotation.Nullable;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 20.11.16.
 */
public class PgActivityEggTimer extends PgActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_egg_timer);
    }
}
