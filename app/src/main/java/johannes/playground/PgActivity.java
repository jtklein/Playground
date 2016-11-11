package johannes.playground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //
        switch (item.getItemId()){

            case R.id.menuItemGoHome:
                // Simple explicit intent to go to main
                Intent intent = new Intent(this, PgActivityMain.class);
                startActivity(intent);
                return true;
            case R.id.menuItemFingerprint:
                Toast.makeText(this, "Nothing here yet!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
