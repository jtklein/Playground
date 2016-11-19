package johannes.playground.architecture.timer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import johannes.playground.L;
import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityTimer extends PgActivity {

    private SeekBar mSeekBarDuration = null;
    private SeekBar mSeekBarTick = null;

    private TextView mTextViewDuration = null;
    private TextView mTextViewTick = null;

    private Button mButton = null;

    private static final int minValueDuration = 2;
    private static final int minValueTick = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_timer);

        mSeekBarDuration = (SeekBar) findViewById(R.id.seekBarDurationTimer);
        mSeekBarTick = (SeekBar) findViewById(R.id.seekBarTickTimer);

        mTextViewDuration = (TextView) findViewById(R.id.textViewDurationTimer);
        mTextViewTick = (TextView) findViewById(R.id.textViewTickTimer);

        mButton = (Button) findViewById(R.id.buttonStartTimer);

        mSeekBarDuration.setProgress(minValueDuration);
        mSeekBarTick.setProgress(minValueTick);

        mSeekBarDuration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // Limit min workaround
                if (i < minValueDuration){
                    i = minValueDuration;
                    mSeekBarDuration.setProgress(minValueDuration);
                }

                // Set text
                String text = String.valueOf(i) + "s";
                mTextViewDuration.setText(text);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });

        mSeekBarTick.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // Limit min workaround
                if (i < minValueTick){
                    i = minValueTick;
                    mSeekBarTick.setProgress(minValueTick);
                }

                // Set text
                String text = String.valueOf(i) + "s";
                mTextViewTick.setText(text);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int duration = mSeekBarDuration.getProgress() * 1000;
                int tick = mSeekBarTick.getProgress() * 1000;

                new CountDownTimer(duration, tick) {
                    @Override
                    public void onTick(long l) {
                        L.t(getApplicationContext(), "Tick!");
                    }

                    @Override
                    public void onFinish() {
                        L.t(getApplicationContext(), "Boom!", 0);

                    }
                }.start();
            }
        });
    }
}
