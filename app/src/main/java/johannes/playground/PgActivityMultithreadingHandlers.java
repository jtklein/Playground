package johannes.playground;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * Created by johannesklein on 16.11.16.
 */
public class PgActivityMultithreadingHandlers extends PgActivity {

    Thread thread;
    Handler handler;

    private ProgressBar mProgressBar = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_multithreading_handlers);

        // Get layout elements
        mProgressBar = (ProgressBar) findViewById(R.id.progressBarHandlers);

        // Create new handler that receives messages
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                mProgressBar.setProgress(msg.arg1);
            }
        };

        // Create and start background thread
        thread = new Thread(new MyThread());
        thread.start();

    }

    class MyThread implements Runnable {

        Message msg = Message.obtain();

        @Override
        public void run() {

            for (int i = 0; i < 100; i++){
                msg.arg1 = i+1;
                handler.dispatchMessage(msg);
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    Log.e(this.getClass().getSimpleName(), "Error Interruption in sleeping Thread");
                    e.printStackTrace();
                }

            }

        }
    }
}
