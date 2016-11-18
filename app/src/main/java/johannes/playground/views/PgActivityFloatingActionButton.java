package johannes.playground.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListView;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 15.11.16.
 */
public class PgActivityFloatingActionButton extends PgActivity {

    private ListView mListView = null;
    private FloatingActionButton mFAB = null;

    private PgListViewExampleItem[] mData = new PgListViewExampleItem[]{
            new PgListViewExampleItem("Item No 1", "", ""),
            new PgListViewExampleItem("Item No 2", "", ""),
            new PgListViewExampleItem("Item No 3", "", ""),
            new PgListViewExampleItem("Item No 4", "", ""),
            new PgListViewExampleItem("Item No 5", "", ""),
    };

    private PgListViewExampleAdapter mAdapter;

    int count = 5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_floating_action_button);

        mListView = (ListView) findViewById(R.id.listViewFAB);
        mFAB = (FloatingActionButton) findViewById(R.id.fabFAB);

        mAdapter = new PgListViewExampleAdapter(this, R.layout.pg_listview_item, mData);

        mListView.setAdapter(mAdapter);

        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;

                PgListViewExampleItem[] newData = new PgListViewExampleItem[count];

                for (int i = 0; i < mData.length; i++){

                    newData[i] = mData[i];
                }

                PgListViewExampleItem newItem = new PgListViewExampleItem("Item no " + count, "", "");
                newData[count-1] = newItem;

                mData = newData;

                // TODO REload data
            }
        });

    }
}
