package johannes.playground;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by johannesklein on 13.11.16.
 */

public class PgTimePickerDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Create a calendar object, get current time as starting point for picker
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.HOUR;
        int minute = currentTime.MINUTE;

        // Create a new TimePickerDialog and return
        return new TimePickerDialog(getActivity(), this, hour, minute, true);

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

        // Do something with the time selected
    }
}
