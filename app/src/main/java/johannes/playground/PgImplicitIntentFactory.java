package johannes.playground;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

/**
 * Created by johannesklein on 18.11.16.
 */

public class PgImplicitIntentFactory {

    private Context mContext = null;

    private Intent implicitIntent = null;

    public PgImplicitIntentFactory(Context mContext) {
        this.mContext = mContext;

    }

    public void browserIntent(String url){
        // Open web browser
        implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startIntent();

    }

    private void startIntent(){
        if (implicitIntent != null){
            if (isIntentAvailable(implicitIntent)){
                mContext.startActivity(implicitIntent);

            } else {
                L.t(mContext, "Could not find a package for this action!");

            }
        }
    }

    private boolean isIntentAvailable(Intent intent){
        PackageManager packageManager = mContext.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,0);
        boolean isIntentSafe = activities.size() > 0;
        return isIntentSafe;

    }
}
