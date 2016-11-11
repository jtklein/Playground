package johannes.playground;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by johannesklein on 11.11.16.
 */
public class PgActivityFiles extends AppCompatActivity{

    private Button mButtonOpenFile = null;
    private Button mButtonSaveFile = null;
    private EditText mEditText = null;

    private static final String FILE_NAME = "example_file_name";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_files);

        mButtonOpenFile = (Button) findViewById(R.id.buttonOpenFile);
        mButtonSaveFile = (Button) findViewById(R.id.buttonSaveFile);
        mEditText = (EditText) findViewById(R.id.editTextTextFile);

        mButtonOpenFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTextFile();
                mEditText.setText(openTextFile());

            }
        });

        mButtonSaveFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTextFile(mEditText.getText().toString());
            }
        });
    }

    /**
     * Save a string to file
     * @param textToSave the {@String} to save
     */
    private void saveTextFile(String textToSave) {
        // Reference to output stream
        OutputStream outputStream = null;

        try {
            // Open file output stream
            outputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            outputStream.write(textToSave.getBytes());

        } catch (FileNotFoundException e) {
            Log.e(this.getClass().getSimpleName(), "Error specified file not found");
            Toast.makeText(this, "Sorry, something went wrong", Toast.LENGTH_SHORT).show();
            e.printStackTrace();

        } catch (IOException e) {
            Log.e(this.getClass().getSimpleName(), "Error IO in opening text file");
            e.printStackTrace();

        } finally {
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    Log.e(this.getClass().getSimpleName(), "Error IO in closing output stream");
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Reading file from system
     */
    private String openTextFile() {

        InputStream inputStream = null;
        String fileText = null;

        try {
            // Open input stream
            inputStream = openFileInput(FILE_NAME);

            // Get buffer size for file
            int size = inputStream.available();
            byte[] buffer = new byte[size];

            // Read file through buffer
            inputStream.read(buffer);
            inputStream.close();

            // Create string from text file content
            fileText = new String(buffer,"UTF-8");

        } catch (FileNotFoundException e) {
            Log.e(this.getClass().getSimpleName(), "Error could not find specified file");
            Toast.makeText(this, "Try saving the file first.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();

        } catch (IOException e){
            Log.e(this.getClass().getSimpleName(), "Error IO reading file");
            e.printStackTrace();

        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e(this.getClass().getSimpleName(), e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        return fileText;
    }
}
