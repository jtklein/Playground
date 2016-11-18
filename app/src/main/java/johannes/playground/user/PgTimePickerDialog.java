package johannes.playground.user;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import johannes.playground.R;

/**
 * Created by johannesklein on 13.11.16.
 */

public class PgTimePickerDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Create a calendar object, get current time as starting point for picker
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR);
        int minute = currentTime.get(Calendar.MINUTE);

        // Create a new TimePickerDialog and return
        Dialog dialog = new TimePickerDialog(getActivity(), this, hour, minute, true);
        return dialog;

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        // Display selected time in the activity
        TextView textViewTimePicked = (TextView) getActivity().findViewById(R.id.textViewTimePicked);
        String selectedTime = hour + ":" + minute;
        textViewTimePicked.setText(selectedTime);

    }
}
