package johannes.playground.navigation;

import android.os.Bundle;

import johannes.playground.PgActivityButtonMenu;
import johannes.playground.PgListViewButtonMenuItem;
import johannes.playground.R;
import johannes.playground.navigation.tabs.PgActivityTabs;

/**
 * Created by johannesklein on 20.11.16.
 */
public class PgActivityNavigation extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            new PgListViewButtonMenuItem(R.string.ui_tabs, PgActivityTabs.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTheAdapter(mData);
    }
}
