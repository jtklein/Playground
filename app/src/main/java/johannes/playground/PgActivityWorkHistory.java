package johannes.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

/**
 * Created by johannesklein on 17.11.16.
 */
public class PgActivityWorkHistory extends PgActivity {

    private PgListViewWorkHistoryItem[] mData = new PgListViewWorkHistoryItem[]{
            new PgListViewWorkHistoryItem("Date", "Job"),
    };

    private ListView mListView = null;

    private PgListViewWorkHistoryAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_work_history);

        mListView = (ListView) findViewById(R.id.listView);

        mAdapter = new PgListViewWorkHistoryAdapter(this, R.layout.pg_listview_item, mData);

        if (mAdapter != null){
            mListView.setAdapter(mAdapter);
        }
    }
}
