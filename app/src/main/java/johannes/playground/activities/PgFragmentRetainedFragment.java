package johannes.playground.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by johannesklein on 17.11.16.
 */

public class PgFragmentRetainedFragment extends Fragment {

    // Tag key for the retained fragment
    public static final String TAG_RETAINED_FRAGMENT = "retained_fragment";

    // Callback interface to communicate to activity from background
    public static interface TaskStatusCallback {
        void onPreExecute();

        void onProgressUpdate(int progress);

        void onPostExecute();

        void onCancelled();
    }

    TaskStatusCallback mStatusCallback;

    BackgroundTask mBackgroundTask = null;
    boolean isTaskExecuting = false;

    /**
     * Called when a fragment is first attached to its activity.
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Get the new instance of the activity and set callback
        mStatusCallback = (TaskStatusCallback) activity;
    }

    /**
     * Called once to do initial creation of a fragment.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the fragment to be retained, i.e. onDestroy and onCreate will not be called
        setRetainInstance(true);
    }

    /**
     * Called when the fragment is no longer attached to its activity.
     */
    @Override
    public void onDetach() {
        super.onDetach();

        // Clear callback in case the activity is recreated
        mStatusCallback = null;
    }

    public void startBackgroundTask() {
        // Start a new background task if not already executing
        if(!isTaskExecuting){
            mBackgroundTask = new BackgroundTask();
            mBackgroundTask.execute();
            isTaskExecuting = true;
        }
    }

    public void cancelBackgroundTask() {
        // Cancel background task if running
        if(isTaskExecuting){
            mBackgroundTask.cancel(true);
            isTaskExecuting = false;
        }
    }

    public void updateExecutingStatus(boolean isExecuting){
        // Update background status
        this.isTaskExecuting = isExecuting;
    }

    private class BackgroundTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            // Give callback to activity
            if(mStatusCallback != null)
                mStatusCallback.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Simple background task that counts forward
            int progress = 0;
            while(progress < 100 && !isCancelled()){
                progress++;
                publishProgress(progress);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Log.e(this.getClass().getSimpleName(), "Error Thread is interrupted");
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Give callback to activity
            if(mStatusCallback != null)
                mStatusCallback.onPostExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // Give callback to activity
            if(mStatusCallback != null)
                // Send background task progress
                mStatusCallback.onProgressUpdate(values[0]);
        }

        @Override
        protected void onCancelled(Void result) {
            // Give callback to activity
            if(mStatusCallback != null)
                mStatusCallback.onCancelled();
        }
    }

}
