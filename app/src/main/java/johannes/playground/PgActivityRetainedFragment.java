package johannes.playground;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by johannesklein on 17.11.16.
 */
public class PgActivityRetainedFragment extends PgActivity implements PgFragmentRetainedFragment.TaskStatusCallback {

    private PgFragmentRetainedFragment mFragment = null;
    private ProgressBar mProgressBar = null;
    private TextView mProgressvalue = null;
    private Button mButtonStart = null;
    private Button mButtonCancel = null;
    private Button mButtonRecreate = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_retained_fragment);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBarRetainedFragment);
        mProgressvalue = (TextView) findViewById(R.id.textViewRetainedFragment);

        // If activity is recreated get progress from saved instances
        if (savedInstanceState != null) {
            int progress = savedInstanceState.getInt("progress_value");
            mProgressvalue.setText(progress + "%");
            mProgressBar.setProgress(progress);
        }

        // Find the retained fragment attached to the activity
        FragmentManager fragmentManager = getFragmentManager();
        mFragment = (PgFragmentRetainedFragment) fragmentManager
                .findFragmentByTag(PgFragmentRetainedFragment.TAG_RETAINED_FRAGMENT);

        // If no fragment has been attached add new instance
        if (mFragment == null) {
            mFragment = new PgFragmentRetainedFragment();
            fragmentManager.beginTransaction()
                    .add(mFragment, PgFragmentRetainedFragment.TAG_RETAINED_FRAGMENT)
                    .commit();

        }

        mButtonStart = (Button) findViewById(R.id.buttonStartRetainedFragment);
        mButtonCancel = (Button) findViewById(R.id.buttonCancelRetainedFragment);
        mButtonRecreate = (Button) findViewById(R.id.buttonRecreateRetainedFragment);

        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mFragment != null)
                    mFragment.startBackgroundTask();
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mFragment != null)
                    mFragment.cancelBackgroundTask();
            }
        });

        mButtonRecreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

    }

    /**
     * This method is called before an activity may be killed.
     * Store info in bundle if required.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("progress_value", mProgressBar.getProgress());
    }

    // Background task Callbacks

    @Override
    public void onPreExecute() {
        Toast.makeText(getApplicationContext(), "onPreExecute",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPostExecute() {
        Toast.makeText(getApplicationContext(), "onPostExecute",
                Toast.LENGTH_SHORT).show();
        if (mFragment != null)
            mFragment.updateExecutingStatus(false);
    }

    @Override
    public void onCancelled() {
        Toast.makeText(getApplicationContext(), "onCancelled",
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProgressUpdate(int progress) {
        mProgressvalue.setText(progress + "%");
        mProgressBar.setProgress(progress);
    }

}
