package johannes.playground.data;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.os.FileObserver;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import johannes.playground.PgActivity;
import johannes.playground.PgSimpleExplicitIntentFactory;
import johannes.playground.R;

/**
 * Created by johannesklein on 18.11.16.
 */
public class PgActivityLoader extends PgActivity {
    // A RecyclerView.Adapter which will display the data
    private ArrayAdapter<String> mAdapter;

    private ListView mListView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_loader);

        mListView = (ListView) findViewById(R.id.listViewLoader);
    public static class JsonAsyncTaskLoader extends AsyncTaskLoader<List<String>> {

        // The result of the task
        private List<String> mData;

        private FileObserver mFileObserver;

        public JsonAsyncTaskLoader(Context context) {
            super(context);
        }

        /*
            --> Runs on UI thread
         */

        @Override
        protected void onStartLoading() {
            if (mData != null) {
                // Use cached data when present
                deliverResult(mData);

            }
            if (mFileObserver == null) {
                String path = new File(getContext().getFilesDir(), "downloaded.json").getPath();
                mFileObserver = new FileObserver(path) {
                    @Override
                    public void onEvent(int event, String path) {
                        // Notify the loader to reload the data
                        onContentChanged();
                        // If the loader is started, this will kick off
                        // loadInBackground() immediately. Otherwise,
                        // the fact that something changed will be cached
                        // and can be later retrieved via takeContentChanged()
                    }
                };
                mFileObserver.startWatching();
            }
            if (takeContentChanged() || mData == null) {
                // We have no data or FileObserver registered a change, so start loading
                forceLoad();

            }
        }

        /*
            <-- Runs on UI thread
         */

        /*
            --> Runs on background thread
         */

        @Override
        public List<String> loadInBackground() {
            // Good to know: the Context returned by getContext() is the application context
            File jsonFile = new File(getContext().getFilesDir(), "downloaded.json");
            List<String> data = new ArrayList<>();
            for (int i = 0; i < 100; i++){
                String randomNumber = String.valueOf((int) (Math.random() * 100));
                data.add("Item " + randomNumber);
            }

            // TODO Background stuff, e.g. get file, parsing JSON
            // Check isLoadInBackgroundCanceled() to cancel out early
            return data;
        }

        /*
            <-- Runs on background thread
         */

        /*
            --> Runs on UI Thread
         */

        @Override
        public void deliverResult(List<String> data) {
        }

        /*
            <-- Runs on UI Thread
         */

        @Override
        protected void onReset() {
            // Stop watching for file changes
            if (mFileObserver != null) {
                mFileObserver.stopWatching();
                mFileObserver = null;
            }
        }
    }
}
