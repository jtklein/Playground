package johannes.playground.examples.hikerwatch;

import android.Manifest;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

import johannes.playground.PgActivityPermission;
import johannes.playground.R;

/**
 * Created by johannesklein on 22.11.16.
 */
public class PgActivityHikerWatch extends PgActivityPermission {

    private TextView mTextViewLatitude  = null;
    private TextView mTextViewLongitude = null;
    private TextView mTextViewAccuracy  = null;
    private TextView mTextViewAltitude  = null;
    private TextView mTextViewAddress   = null;

    private LocationManager mManager = null;
    private HikerWatcher mListener = null;

    private Location currentLocation = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_hiker_watch);

        mTextViewLatitude  = (TextView) findViewById(R.id.textViewLatitudeHikerWatch);
        mTextViewLongitude = (TextView) findViewById(R.id.textViewLongitudeHikerWatch);
        mTextViewAccuracy  = (TextView) findViewById(R.id.textViewAccuracyHikerWatch);
        mTextViewAltitude  = (TextView) findViewById(R.id.textViewAltitudeHikerWatch);
        mTextViewAddress   = (TextView) findViewById(R.id.textViewAddressHikerWatch);

        mManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        mListener = new HikerWatcher();

        if (super.handlePermissions(Manifest.permission.ACCESS_FINE_LOCATION)){
            // Get last known location, update views then follow location changes
            currentLocation = mManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            updateViews();
            mManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mListener);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (super.handlePermissions(Manifest.permission.ACCESS_FINE_LOCATION)){
            // Remove location listener
            mManager.removeUpdates(mListener);
        }
        mManager = null;

    }

    private void updateViews() {

        mTextViewLatitude.setText(String.valueOf(currentLocation.getLatitude()));
        mTextViewLongitude.setText(String.valueOf(currentLocation.getLongitude()));

        mTextViewAccuracy.setText(String.valueOf(currentLocation.getAccuracy()));
        mTextViewAltitude.setText(String.valueOf(currentLocation.getAltitude()));

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        try {
            List<Address> addressList = geocoder.getFromLocation(currentLocation.getLatitude(), currentLocation.getLongitude(), 1);

            if (addressList != null && addressList.size() > 0){
                Address address = addressList.get(0);
                mTextViewAddress.setText("");

                for (int i = 0; i <= address.getMaxAddressLineIndex(); i++){
                    String text = mTextViewAddress.getText().toString();
                    mTextViewAddress.setText(text + "\n" + address.getAddressLine(i));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private class HikerWatcher implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            currentLocation = location;
            updateViews();
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    }
}
