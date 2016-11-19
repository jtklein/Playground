package johannes.playground.user;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
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
    private AudioManager mManager = null;

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

        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start audio file
                mMediaPlayer.start();

            }
        });

        mButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SPause audio file
                mMediaPlayer.pause();

            }
        });

        // Get an instance of the AudioManager
        mManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Get current and max volume
        int maxVolume = mManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = mManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // Translate possible Volume into SeekBar MaxValue
        mSeekBarVolume.setMax(maxVolume);
        mSeekBarVolume.setProgress(curVolume);

        mSeekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                mManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
