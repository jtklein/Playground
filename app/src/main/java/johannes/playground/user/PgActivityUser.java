package johannes.playground.user;

import android.os.Bundle;

import johannes.playground.PgActivityButtonMenu;
import johannes.playground.PgListViewButtonMenuItem;
import johannes.playground.R;

/**
 * Created by johannesklein on 12.11.16.
 */
public class PgActivityUser extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            new PgListViewButtonMenuItem(R.string.ui_toast, PgActivityToast.class),
            new PgListViewButtonMenuItem(R.string.ui_notification, PgActivityNotification.class),
            new PgListViewButtonMenuItem(R.string.ui_dialog, PgActivityDialog.class),
            new PgListViewButtonMenuItem(R.string.ui_picker, PgActivityPicker.class),
            new PgListViewButtonMenuItem(R.string.ui_animations, PgActivityAnimations.class),
            new PgListViewButtonMenuItem(R.string.ui_video, PgActivityVideo.class),
            new PgListViewButtonMenuItem(R.string.ui_audio, PgActivityAudio.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setTheAdapter(mData);

    }
}
