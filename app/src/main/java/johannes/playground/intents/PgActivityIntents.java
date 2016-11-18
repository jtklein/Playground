package johannes.playground.intents;

import android.os.Bundle;

import johannes.playground.PgActivityButtonMenu;
import johannes.playground.PgListViewButtonMenuItem;
import johannes.playground.R;

public class PgActivityIntents extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            new PgListViewButtonMenuItem(R.string.ui_implicit_intents, PgActivityImplicitIntents.class),
            new PgListViewButtonMenuItem(R.string.ui_intent_extras, PgActivitySendIntentExtras.class),
            new PgListViewButtonMenuItem(R.string.ui_intent_request, PgActivityIntentRequest.class),
            new PgListViewButtonMenuItem(R.string.ui_intent_receiver, PgActivityIntentReceiver.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setTheAdapter(mData);

    }
}
