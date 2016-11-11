package johannes.playground;

import android.app.Fragment;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by johannesklein on 11.11.16.
 */
public class PgFragmentLifecycle extends Fragment {

    private int mOrder = 0;
    private String mStatus = "";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mStatus = "onAttach";
        displayStatus();
    }

    private void displayStatus() {
        //Create String
        mOrder++;
        String toastText = String.valueOf(mOrder) + ") Activity is in: " + mStatus;

        // Display Toast
        Toast.makeText(this.getContext(), toastText, Toast.LENGTH_SHORT).show();

    }
}
