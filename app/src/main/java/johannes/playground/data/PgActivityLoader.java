package johannes.playground.data;

import android.os.Bundle;
import android.support.annotation.Nullable;

import johannes.playground.PgActivity;
import johannes.playground.PgSimpleExplicitIntentFactory;
import johannes.playground.R;

/**
 * Created by johannesklein on 18.11.16.
 */
public class PgActivityLoader extends PgActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_loader);

    }
}
