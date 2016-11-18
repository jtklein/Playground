package johannes.playground.activities;

import android.os.Bundle;

import johannes.playground.PgActivityButtonMenu;
import johannes.playground.PgListViewButtonMenuItem;
import johannes.playground.R;

public class PgActivityActivities extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            new PgListViewButtonMenuItem(R.string.ui_activity_lifecycle, PgActivityLifecycle.class),
            new PgListViewButtonMenuItem(R.string.ui_fragment_lifecycle, PgActivityFragmentLifecycle.class),
            new PgListViewButtonMenuItem(R.string.ui_retained_fragment, PgActivityRetainedFragment.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setTheAdapter(mData);

    }
}
