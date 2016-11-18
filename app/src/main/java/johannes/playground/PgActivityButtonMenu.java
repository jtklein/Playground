package johannes.playground;

import android.os.Bundle;
import android.widget.ListView;

public class PgActivityButtonMenu extends PgActivity {

    private ListView mListView = null;

    private PgListViewButtonMenuAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_button_menu);

        mListView = (ListView) findViewById(R.id.listViewButtonMenu);

    }

    public void setTheAdapter(PgListViewButtonMenuItem[] data){

        mAdapter = new PgListViewButtonMenuAdapter(this, R.layout.pg_listview_button_menu_item, data);

        mListView.setAdapter(mAdapter);

    }
}
