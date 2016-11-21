package johannes.playground.data.location;

import android.os.Bundle;
import android.support.annotation.Nullable;

import johannes.playground.PgActivityButtonMenu;
import johannes.playground.PgListViewButtonMenuItem;
import johannes.playground.R;

/**
 * Created by johannesklein on 21.11.16.
 */
public class PgActivityLocation extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            // Full content
            new PgListViewButtonMenuItem(R.string.ui_location_awareness, PgActivityLocationAwareness.class),
            new PgListViewButtonMenuItem(R.string.ui_basic_map, PgActivityBasicMap.class),
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTheAdapter(mData);

    }
}
