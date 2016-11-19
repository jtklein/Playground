package johannes.playground.user;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityAudio extends PgActivity {
    private MediaPlayer mMediaPlayer = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_audio);

        // Get new MediaPlayer instance
        mMediaPlayer = MediaPlayer.create(this, R.raw.laugh);
        mMediaPlayer.start();
    }
}
