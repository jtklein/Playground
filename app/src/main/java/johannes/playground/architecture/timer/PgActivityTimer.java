package johannes.playground.architecture.timer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.SeekBar;
import android.widget.TextView;

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

        mSeekBarDuration.setProgress(minValueDuration);
        mSeekBarTick.setProgress(minValueTick);


    }
}
