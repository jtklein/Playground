package johannes.playground;

import android.os.Bundle;

import johannes.playground.activities.PgActivityActivities;
import johannes.playground.architecture.PgActivityArchitecture;
import johannes.playground.data.PgActivityData;
import johannes.playground.examples.PgActivityExamples;
import johannes.playground.intents.PgActivityIntents;
import johannes.playground.navigation.PgActivityNavigation;
import johannes.playground.persistance.PgActivityPersistance;
import johannes.playground.user.PgActivityUser;
import johannes.playground.views.PgActivityViews;

public class PgActivityMain extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            new PgListViewButtonMenuItem(R.string.ui_examples, PgActivityExamples.class),
            new PgListViewButtonMenuItem(R.string.ui_activities, PgActivityActivities.class),
            new PgListViewButtonMenuItem(R.string.ui_intents, PgActivityIntents.class),
            new PgListViewButtonMenuItem(R.string.ui_persistance, PgActivityPersistance.class),
            new PgListViewButtonMenuItem(R.string.ui_data, PgActivityData.class),
            new PgListViewButtonMenuItem(R.string.ui_user, PgActivityUser.class),
            new PgListViewButtonMenuItem(R.string.ui_views, PgActivityViews.class),
            new PgListViewButtonMenuItem(R.string.ui_architecture, PgActivityArchitecture.class),
            new PgListViewButtonMenuItem(R.string.ui_navigation, PgActivityNavigation.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setTheAdapter(mData);

    }
}
