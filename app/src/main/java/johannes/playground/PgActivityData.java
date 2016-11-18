package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by johannesklein on 10.11.16.
 */
public class PgActivityData extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            new PgListViewButtonMenuItem(R.string.ui_parse_json, PgActivityParseJSON.class),
            new PgListViewButtonMenuItem(R.string.ui_control_flow, PgActivityControlFlow.class),
            new PgListViewButtonMenuItem(R.string.ui_networking, PgActivityNetworking.class),
            new PgListViewButtonMenuItem(R.string.ui_multithreading, PgActivityMultithreading.class),
            new PgListViewButtonMenuItem(R.string.ui_multithreading_handlers, PgActivityMultithreadingHandlers.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setTheAdapter(mData);

    }
}


