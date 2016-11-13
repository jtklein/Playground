package johannes.playground;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by johannesklein on 13.11.16.
 */

public class PgDatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Gett current system date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.YEAR;
        int month = calendar.MONTH;
        int dayOfMonth = calendar.DAY_OF_MONTH;

        // Create a DatePickerDialog and return, set to current time
        return new DatePickerDialog(getActivity(), this, year, month, dayOfMonth);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        // Do something on tie selected.

    }
}
