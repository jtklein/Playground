package johannes.playground.user;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.SeekBar;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityAudio extends PgActivity {

    private Button mButtonPlay  = null;
    private Button mButtonPause = null;

    private SeekBar mSeekBarVolume = null;
    private SeekBar mSeekBarScrubber = null;

    private MediaPlayer mMediaPlayer = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_audio);

        mButtonPlay = (Button) findViewById(R.id.buttonPlayAudio);
        mButtonPause = (Button) findViewById(R.id.buttonPauseAudio);

        mSeekBarVolume = (SeekBar) findViewById(R.id.seekBarVolumeAudio);
        mSeekBarScrubber = (SeekBar) findViewById(R.id.seekBarScrubAudio);

        // Get new MediaPlayer instance
        mMediaPlayer = MediaPlayer.create(this, R.raw.laugh);
        mMediaPlayer.start();
    }
}
