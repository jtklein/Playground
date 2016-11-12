package johannes.playground;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by johannesklein on 11.11.16.
 */
public class PgActivityControlFlow extends PgActivity {

    private Button mButton = null;
    private Spinner mSpinner = null;
    private EditText mEditText = null;

    private static final char[] mAlphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

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
                    checkPangram(sentenceToTest);

                } else {

                    String pangram = mSpinner.getSelectedItem().toString();
                    char[] sentenceToTest = toCharacterArray(pangram);
                    checkPangram(sentenceToTest);

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

    private void checkPangram(char[] sentenceToTest) {

        if (sentenceToTest.length == 0){

            Toast.makeText(this, "Try writing one, or select one.", Toast.LENGTH_SHORT).show();
            return;
        }

        int lettersMissing = 0;

        for (int i = 0; i < mAlphabet.length; i++){
            for (int j = 0; j < sentenceToTest.length; j++){
                if (mAlphabet[i] == sentenceToTest[j]){
                    break;
                } else if (j == sentenceToTest.length -1){
                    lettersMissing++;
                }
            }
        }

        if (lettersMissing == 0){
            Toast.makeText(this, "Yes it's a pangram!", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "No, try again! " + lettersMissing + " letters missing.", Toast.LENGTH_SHORT).show();

        }
    }
}
