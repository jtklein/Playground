package johannes.playground;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by johannesklein on 21.11.16.
 */

public class PgActivityPermission extends PgActivity {

    private final static int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1122;

    private final static int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 2233;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public boolean handlePermissions(String permissionName) {
        // If build smaller than Marshmallow no runtime permission requests are needed
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }

        // Handle permission request based on permission name, return if permission was granted
        switch (permissionName) {
            case Manifest.permission.ACCESS_FINE_LOCATION:
                // If the user did not grant Fine Location permission, request it
                if (!this.hasFineLocationPermission()) {
                    this.requestFineLocationPermissions();
                    return this.hasFineLocationPermission();

                }
                return true;

            case Manifest.permission.ACCESS_COARSE_LOCATION:
                // If the user did not grant Coarse Location permission, request it
                if (!this.hasCoarseLocationPermission()) {
                    this.requestCoarseLocationPermissions();
                    return this.hasCoarseLocationPermission();
                }
                return true;
            default:
                // Act as if we don't have permission
                return false;

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        // The results of the asking for permission dialogue
        switch (requestCode) {
            // Callback is from the ACCESS_FINE_LOCATION permission
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // ACCESS_FINE_LOCATION permission was granted
                    // nothing to do here

                } else {

                    // ACCESS_FINE_LOCATION permission denied
                    // TODO show explanation why we need it
                }
                return;
            }
            // Callback is from the ACCESS_COARSE_LOCATION permission
            case MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // ACCESS_COARSE_LOCATION permission was granted
                    // nothing to do here

                } else {

                    // ACCESS_COARSE_LOCATION permission denied
                    // TODO show explanation why we need it
                }
                return;
            }
        }
    }

    private void requestFineLocationPermissions() {
        // Request the permission.
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);

    }

    private void requestCoarseLocationPermissions() {
        // Request the permission.
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);

    }

    private Boolean hasFineLocationPermission() {
        // Check if we have fine location access
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            return true;

        } else {
            return false;

        }
    }

    private Boolean hasCoarseLocationPermission() {
        // Check if we have fine location access
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            return true;

        } else {
            return false;

        }
    }
}
