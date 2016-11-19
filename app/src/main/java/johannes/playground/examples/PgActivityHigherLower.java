package johannes.playground.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

import johannes.playground.L;
import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityHigherLower extends PgActivity {

    int randomNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_higher_lower);

        generateRandom();
    }

    public void guess(View view) {

        EditText editText = (EditText) findViewById(R.id.editTextHigherLower);

        int guessInt = 0;
        if (editText.getText().toString().length() != 0){
            guessInt = Integer.parseInt(editText.getText().toString());
        }

        if (guessInt != 0){
            if (guessInt > randomNumber){

            } else if (guessInt < randomNumber){

            } else {

                generateRandom();

            }
        }
    }

    private void generateRandom() {
        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;
    }
}
