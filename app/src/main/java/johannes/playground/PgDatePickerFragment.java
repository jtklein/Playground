package johannes.playground;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by johannesklein on 13.11.16.
 */

public class PgDatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Get current system date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog and return, set to current time
        Dialog dialog = new DatePickerDialog(getActivity(), this, year, month, dayOfMonth);
        return dialog;

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        // Display chosen date in the activity
        TextView textViewDatePicked = (TextView) getActivity().findViewById(R.id.textViewDatePicked);
        String selectedDate = day + "/" + month + "/" + year;
        textViewDatePicked.setText(selectedDate);

    }
}
