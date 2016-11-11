package johannes.playground;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

/**
 * Created by johannesklein on 11.11.16.
 */

public class PgActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }
}
