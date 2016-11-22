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
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

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


    }
}
