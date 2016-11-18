package johannes.playground.activities;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import johannes.playground.R;

/**
 * Created by johannesklein on 11.11.16.
 */
public class PgFragmentLifecycle extends Fragment {

    private int mOrder = 0;
    private String mStatus = "";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mStatus = "onAttach";
        displayStatus();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mStatus = "onCreate";
        displayStatus();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pg_fragment_lifecycle, container, false);

        mStatus = "onCreateView";
        displayStatus();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mStatus = "onViewCreated";
        displayStatus();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mStatus = "onActivityCreated";
        displayStatus();
    }

    @Override
    public void onStart() {
        super.onStart();

        mStatus = "onStart";
        displayStatus();
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        mStatus = "onViewStateRestored";
        displayStatus();
    }

    @Override
    public void onResume() {
        super.onResume();

        mStatus = "onResume";
        displayStatus();
    }

    @Override
    public void onPause() {
        super.onPause();

        mStatus = "onPause";
        displayStatus();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mStatus = "onSaveInstanceState";
        displayStatus();
    }

    @Override
    public void onStop() {
        super.onStop();

        mStatus = "onStop";
        displayStatus();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mStatus = "onDestroyView";
        displayStatus();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mStatus = "onDestroy";
        displayStatus();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mStatus = "onDetach";
        displayStatus();
    }

    private void displayStatus() {
        //Create String
        mOrder++;
        String toastText = String.valueOf(mOrder) + ") Fragment is in: " + mStatus;

        // Display Toast
        Toast.makeText(this.getContext(), toastText, Toast.LENGTH_SHORT).show();

    }
}
