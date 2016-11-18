package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PgActivityMain extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            new PgListViewButtonMenuItem(R.string.ui_activities, PgActivityActivities.class),
            new PgListViewButtonMenuItem(R.string.ui_intents, PgActivityIntents.class),
            new PgListViewButtonMenuItem(R.string.ui_persistance, PgActivityPersistance.class),
            new PgListViewButtonMenuItem(R.string.ui_data, PgActivityData.class),
            new PgListViewButtonMenuItem(R.string.ui_user, PgActivityUser.class),
            new PgListViewButtonMenuItem(R.string.ui_views, PgActivityViews.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setTheAdapter(mData);

    }
}
