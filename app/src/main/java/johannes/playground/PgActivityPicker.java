package johannes.playground;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by johannesklein on 13.11.16.
 */
public class PgActivityPicker extends PgActivity {

    private Button mButtonTimePicker = null;
    private Button mButtonDatePicker = null;

    private TextView mTextViewTimePicked = null;
    private TextView mTextViewDatePicked = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_picker);

        mTextViewTimePicked = (TextView) findViewById(R.id.textViewTimePicked);
        mTextViewDatePicked = (TextView) findViewById(R.id.textViewDatePicked);

        mButtonTimePicker = (Button) findViewById(R.id.buttonTimePicker);
        mButtonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new time picker fragment
                DialogFragment fragment = new PgTimePickerDialog();

                // Show the time picker fragment
                getFragmentManager().beginTransaction()
                        .add(fragment, "s")
                        .commit();
            }
        });

        mButtonDatePicker = (Button) findViewById(R.id.buttonDatePicker);
        mButtonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new Date Picker Dialog
                DialogFragment fragment = new PgDatePickerFragment();

                // Show the date picker fragment
                getFragmentManager().beginTransaction()
                        .add(fragment, "SD")
                        .commit();
            }
        });
    }
}
