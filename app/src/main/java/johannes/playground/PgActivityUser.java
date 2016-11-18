package johannes.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by johannesklein on 12.11.16.
 */
public class PgActivityUser extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            new PgListViewButtonMenuItem(R.string.ui_toast, PgActivityToast.class),
            new PgListViewButtonMenuItem(R.string.ui_notification, PgActivityNotification.class),
            new PgListViewButtonMenuItem(R.string.ui_dialog, PgActivityDialog.class),
            new PgListViewButtonMenuItem(R.string.ui_picker, PgActivityPicker.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setTheAdapter(mData);

    }
}
