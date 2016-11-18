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
    }
}
