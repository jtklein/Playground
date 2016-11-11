package johannes.playground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by johannesklein on 11.11.16.
 */
public class PgActivityFiles extends AppCompatActivity{

    private Button mButtonOpenFile = null;
    private Button mButtonSaveFile = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_files);

        mButtonOpenFile = (Button) findViewById(R.id.buttonOpenFile);
        mButtonSaveFile = (Button) findViewById(R.id.buttonSaveFile);

        mButtonOpenFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFile();

            }
        });


    }

    private void openFile() {

    }
}
