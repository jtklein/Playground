package johannes.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by johannesklein on 09.11.16.
 */
public class PgActivityListView extends AppCompatActivity {

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
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_list_view);

        mListView = (ListView) findViewById(R.id.listView);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mData);

        if (mAdapter != null){
            mListView.setAdapter(mAdapter);
        }
    }
}
