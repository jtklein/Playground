package johannes.playground.examples.celebrityguess;

import android.os.Bundle;
import android.support.annotation.Nullable;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 21.11.16.
 */
public class PgActivityCelebrityGuess extends PgActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_celebrity_guess);
    }
}
