package johannes.playground.examples.timestables;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityTimesTables extends PgActivity {

    private SeekBar mSeekBar = null;
    private TextView mTextView = null;
    private ListView mListView = null;

    private ArrayList<String> mData = null;

    private int[] baseValues = null;

    private static final int maxListValue = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_timestables);

        mSeekBar = (SeekBar) findViewById(R.id.seekBarTimesTables);
        mTextView = (TextView) findViewById(R.id.textViewTimesTables);
        mListView = (ListView) findViewById(R.id.listViewTimesTables);

        mData = new ArrayList<String>();

        baseValues = new int[maxListValue];
        for (int i = 0; i < baseValues.length; i++){
            // Build base value array
            baseValues[i] = i + 1;
        }

        // Init SeekBar
        mSeekBar.setProgress(1);
        calculateTimestable();

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // Show progress in text
                mTextView.setText(String.valueOf(i));

                // Calculate new times table
                calculateTimestable();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void calculateTimestable() {
        // Instantiate data Array
        mData = new ArrayList<String>();

        // Add Strings
        for (int i = 0; i < baseValues.length; i++){
            mData.add(String.valueOf(baseValues[i] * mSeekBar.getProgress()));
        }

        // Instantiate and set Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mData);
        mListView.setAdapter(adapter);

    }
}
