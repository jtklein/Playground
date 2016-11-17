package johannes.playground;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;

/**
 * Created by johannesklein on 17.11.16.
 */

public class PgFragmentRetainedFragment extends Fragment {

    public static final String TAG_RETAINED_FRAGMENT = "retained_fragment";

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
        mStatusCallback = (TaskStatusCallback) activity;
    }

    /**
     * Called once to do initial creation of a fragment.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    /**
     * Called when the fragment is no longer attached to its activity.
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mStatusCallback = null;
    }

    public void startBackgroundTask() {
        if(!isTaskExecuting){
            mBackgroundTask = new BackgroundTask();
            mBackgroundTask.execute();
            isTaskExecuting = true;
        }
    }

    public void cancelBackgroundTask() {
        if(isTaskExecuting){
            mBackgroundTask.cancel(true);
            isTaskExecuting = false;
        }
    }

    public void updateExecutingStatus(boolean isExecuting){
        this.isTaskExecuting = isExecuting;
    }

    private class BackgroundTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            if(mStatusCallback != null)
                mStatusCallback.onPreExecute();
        }

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

        @Override
        protected void onPostExecute(Void result) {
            if(mStatusCallback != null)
                mStatusCallback.onPostExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            if(mStatusCallback != null)
                mStatusCallback.onProgressUpdate(values[0]);
        }

        @Override
        protected void onCancelled(Void result) {
            if(mStatusCallback != null)
                mStatusCallback.onCancelled();
        }
    }

}
