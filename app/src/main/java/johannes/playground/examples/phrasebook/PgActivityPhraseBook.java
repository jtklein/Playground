package johannes.playground.examples.phrasebook;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityPhraseBook extends PgActivity {

    private MediaPlayer mMediaPlayer = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_phrasebook);
    }

    public void buttonTapped(View view) {

        // Get filename from viewID, only works when button and raw files are homonym
        int viewID = view.getId();
        String resName = getResources().getResourceEntryName(viewID);
        int resID = getResources().getIdentifier(resName, "raw", getPackageName());

        // Start MediaPlayer for file
        mMediaPlayer = MediaPlayer.create(this, resID);
        mMediaPlayer.start();


    }
}
