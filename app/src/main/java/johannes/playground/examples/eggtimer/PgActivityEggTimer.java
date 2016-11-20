package johannes.playground.examples.eggtimer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 20.11.16.
 */
public class PgActivityEggTimer extends PgActivity {

    private SeekBar mSeekBar = null;
    private Button mButton = null;
    private TextView mTextView = null;

    private EggTimer mEggTimer = null;

    private static final int timerTickInterval = 1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_egg_timer);

        mSeekBar = (SeekBar) findViewById(R.id.seekBarEggTimer);
        mButton = (Button) findViewById(R.id.buttonEggTimer);
        mTextView = (TextView) findViewById(R.id.textViewEggTimer);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEggTimer();

            }
        });

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // If user changes progress bar update view, else Timer does it
                if (b){
                    updateView(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void startEggTimer() {
        // Get the selected duration from seek bar, start timer
        long duration = mSeekBar.getProgress() * 1000 + 100;
        mEggTimer = new EggTimer(duration, timerTickInterval);
        mEggTimer.start();

    }

    private void updateView(int secondsToGo){
        // Calculate remaining min and seconds
        int minutes = secondsToGo / 60;
        int seconds = secondsToGo - minutes * 60;

        // Build String for text view
        String secondText = String.valueOf(seconds);
        if (seconds <= 9){
            secondText = "0" + String.valueOf(seconds);
        }
        String text = String.valueOf(minutes) + ":" + secondText;

        // Update seek bar progress and text view depending on time remaining
        mSeekBar.setProgress(secondsToGo);
        mTextView.setText(text);


    }

    private class EggTimer extends CountDownTimer {

        public EggTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            updateView((int) l / 1000);

        }

        @Override
        public void onFinish() {
            updateView(0);

            // Play sound on finish
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
            mp.start();
        }
    }
}
