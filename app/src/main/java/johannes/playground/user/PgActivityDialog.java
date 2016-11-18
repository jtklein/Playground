package johannes.playground.user;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 13.11.16.
 */
public class PgActivityDialog extends PgActivity {

    private Button mButton = null;
    private EditText mEditText = null;

    private Dialog mDialog = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_dialog);

        mEditText = (EditText) findViewById(R.id.editTextDialogMessage);

        mButton = (Button) findViewById(R.id.buttonBuildDialog);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = mEditText.getText().toString();
                buildDialog(message).show();
            }
        });
    }

    private Dialog buildDialog(String message) {

        // Create new Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Show special message if no text input is given
        if (message.length() == 0){

            builder.setMessage("Please enter some text, it's fun, I promise!");
        } else {
            builder.setMessage(message);
        }

        // Add positive button that displays a Toast
        builder.setPositiveButton("Toast it!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Positive reaction here
                Toast.makeText(getApplicationContext(), "Grilling!", Toast.LENGTH_SHORT).show();
            }
        });

        // Add negative Button to dialog
        builder.setNegativeButton("Abort!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Negative reaction here, nothing to implement, closes the dialog
            }
        });

        // Return the Dialog
        return builder.create();
    }
}
