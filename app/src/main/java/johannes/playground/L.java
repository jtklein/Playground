package johannes.playground;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by johannesklein on 19.11.16.
 */

public class L {

    public static void t(Context context, String string){
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}
