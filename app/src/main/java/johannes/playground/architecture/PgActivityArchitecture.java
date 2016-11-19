package johannes.playground.architecture;

import android.os.Bundle;

import johannes.playground.PgActivityButtonMenu;
import johannes.playground.PgListViewButtonMenuItem;
import johannes.playground.R;
import johannes.playground.architecture.timer.PgActivityTimer;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityArchitecture  extends PgActivityButtonMenu {

    PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            new PgListViewButtonMenuItem(R.string.ui_timer, PgActivityTimer.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTheAdapter(mData);

    }
}
