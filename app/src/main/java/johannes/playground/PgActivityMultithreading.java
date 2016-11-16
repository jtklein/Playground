package johannes.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

/**
 * Created by johannesklein on 16.11.16.
 */
public class PgActivityMultithreading extends PgActivity {

    private EditText mEditText = null;
    private Button mButton = null;
    private ProgressBar mProgressBar = null;
    private ListView mListView = null;
    private LinearLayout mLinearLayoutLoading = null;

    private PgListViewExampleAdapter mAdapter;

    private String[] mLoadingText;
    private String[] mLoadingUrls;

    private PgListViewExampleItem[] mData = new PgListViewExampleItem[2];


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_multithreading);

        mEditText = (EditText) findViewById(R.id.editTextImageDownload);
        mButton = (Button) findViewById(R.id.buttonImageDownload);
        mProgressBar = (ProgressBar) findViewById(R.id.loadingProgress);
        mListView = (ListView) findViewById(R.id.loadingUrls);
        mLinearLayoutLoading = (LinearLayout) findViewById(R.id.loadingSection);

        mLoadingText = getResources().getStringArray(R.array.loading_text);
        mLoadingUrls = getResources().getStringArray(R.array.loading_urls);

        for (int i = 0; i < mData.length; i++){
            mData[i] = new PgListViewExampleItem(mLoadingText[i], mLoadingUrls[i], "No Popup");

        }

        mAdapter = new PgListViewExampleAdapter(this, R.layout.pg_listview_item, mData);

        if (mAdapter != null){
            mListView.setAdapter(mAdapter);
        }



    }
}
