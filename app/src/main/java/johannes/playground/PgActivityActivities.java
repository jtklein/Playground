package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

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
