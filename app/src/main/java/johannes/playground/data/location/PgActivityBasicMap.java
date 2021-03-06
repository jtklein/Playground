package johannes.playground.data.location;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import johannes.playground.R;

public class PgActivityBasicMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_basic_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in place and move the camera
        LatLng place = new LatLng(49.1232698,8.707743);

        mMap.addMarker(new MarkerOptions().position(place).title("Home"));

        // Custom markering
        LatLng placeTwo = new LatLng(49.1234,8.7070);
        mMap.addMarker(new MarkerOptions().position(placeTwo).
                icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        // Zoom goes from one to twenty
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 10));

        // Set map type with satellite
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        try {
            List<Address> addressList = geocoder.getFromLocation(placeTwo.latitude, placeTwo.longitude, 1);

            if (addressList != null && addressList.size() > 0){

                Address address = addressList.get(0);

                Log.i("Address", addressList.get(0).toString());

                for (int i = 0; i <= address.getMaxAddressLineIndex(); i++){

                    Log.i("Address", "" + address.getAddressLine(i));

                }
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
