package johannes.playground;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by johannesklein on 11.11.16.
 */
public class PgActivityControlFlow extends PgActivity {

    private Button mButton = null;
    private Spinner mSpinner = null;
    private EditText mEditText = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_control_flow);

        mButton = (Button) findViewById(R.id.buttonTryPangram);
        mSpinner = (Spinner) findViewById(R.id.spinnerPangram);
        mEditText = (EditText) findViewById(R.id.editTextPangram);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mSpinner.getSelectedItemPosition() == 0){

                    String pangram = mEditText.getText().toString();
                    char[] sentenceToTest = toCharacterArray(pangram);
                } else {

                    String pangram = mSpinner.getSelectedItem().toString();
                    char[] sentenceToTest = toCharacterArray(pangram);
                }
            }
        });
    }

    private char[] toCharacterArray(String pangram) {

        if (pangram == null){
            return null;

        }
        char[] charArray = new char[pangram.length()];
        for (int i = 0; i < pangram.length(); i++){
            charArray[i] = Character.toLowerCase(pangram.charAt(i));
        }
        return charArray;
    }

    }
}
