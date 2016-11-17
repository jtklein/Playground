package johannes.playground;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;

/**
 * Created by johannesklein on 17.11.16.
 */

public class PgFragmentRetainedFragment extends Fragment {

    public static final String TAG_RETAINED_FRAGMENT = "retained_fragment";

    BackgroundTask mBackgroundTask = null;
    /**
     * Called once to do initial creation of a fragment.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }
    private class BackgroundTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            int progress = 0;
            while(progress < 100 && !isCancelled()){
                progress++;
                publishProgress(progress);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
