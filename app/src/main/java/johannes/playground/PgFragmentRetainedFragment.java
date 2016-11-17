package johannes.playground;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by johannesklein on 17.11.16.
 */

public class PgFragmentRetainedFragment extends Fragment {

    public static final String TAG_RETAINED_FRAGMENT = "retained_fragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }
}
