package johannes.playground;

import android.content.Context;
import android.content.Intent;

/**
 * Created by johannesklein on 18.11.16.
 */

public class PgSimpleExplicitIntentFactory {

    private Context mContext = null;
    private Class mClass = null;

    public PgSimpleExplicitIntentFactory(Context mContext, Class mClass) {
        this.mContext = mContext;
        this.mClass = mClass;

    }

    public void generateIntent(){
        Intent intent = new Intent(mContext, mClass);
        mContext.startActivity(intent);

    }
}
