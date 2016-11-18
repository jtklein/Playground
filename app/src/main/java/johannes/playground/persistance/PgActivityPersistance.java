package johannes.playground.persistance;

import android.os.Bundle;

import johannes.playground.PgActivityButtonMenu;
import johannes.playground.PgListViewButtonMenuItem;
import johannes.playground.R;

/**
 * Created by johannesklein on 10.11.16.
 */
public class PgActivityPersistance extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            new PgListViewButtonMenuItem(R.string.ui_shared_preferences, PgActivitySharedPreferences.class),
            new PgListViewButtonMenuItem(R.string.ui_files, PgActivityFiles.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setTheAdapter(mData);

    }
}