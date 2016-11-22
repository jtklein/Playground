package johannes.playground.views;

import android.os.Bundle;

import johannes.playground.PgActivityButtonMenu;
import johannes.playground.PgListViewButtonMenuItem;
import johannes.playground.R;
import johannes.playground.views.webview.PgActivityWebview;

/**
 * Created by johannesklein on 09.11.16.
 */
public class PgActivityViews extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            new PgListViewButtonMenuItem(R.string.ui_webview, PgActivityWebview.class),
            new PgListViewButtonMenuItem(R.string.ui_listview, PgActivityListView.class),
            new PgListViewButtonMenuItem(R.string.ui_fab, PgActivityFloatingActionButton.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setTheAdapter(mData);

    }
}
