package johannes.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

/**
 * Created by johannesklein on 09.11.16.
 */
public class PgActivityListView extends PgActivity {

    private PgListViewExampleItem[] mData = new PgListViewExampleItem[]{
            new PgListViewExampleItem("Header for item", "Body for item", "Popup for item"),
            new PgListViewExampleItem("Header for item", "Body for item", "Popup for item"),
            new PgListViewExampleItem("Header for item", "Body for item", "Popup for item"),
            new PgListViewExampleItem("Header for item", "Body for item", "Popup for item"),
            new PgListViewExampleItem("Header for item", "Body for item", "Popup for item"),
            new PgListViewExampleItem("Header for item", "Body for item", "Popup for item"),
            new PgListViewExampleItem("Header for item", "Body for item", "Popup for item"),
            new PgListViewExampleItem("Header for item", "Body for item", "Popup for item"),
            new PgListViewExampleItem("Header for item", "Body for item", "Popup for item"),
            new PgListViewExampleItem("Header for item", "Body for item", "Popup for item"),
    };

    private ListView mListView = null;

    private PgListViewExampleAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_list_view);

        mListView = (ListView) findViewById(R.id.listView);

        mAdapter = new PgListViewExampleAdapter(this, R.layout.pg_listview_item, mData);

        if (mAdapter != null){
            mListView.setAdapter(mAdapter);
        }
    }
}
