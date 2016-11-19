package johannes.playground.examples.numbershapes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import johannes.playground.L;
import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 19.11.16.
 */

public class PgActivityNumberShapes extends PgActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_number_shapes);

    }

    public void checkNumber(View view) {

        EditText editText = (EditText) findViewById(R.id.editTextNumberShapes);

        if (editText.getText().toString().isEmpty()){

        } else {

            Number inputNumber = new Number();
            inputNumber.number = Integer.parseInt(editText.getText().toString());

            if (inputNumber.isSquare() && inputNumber.isTriangular()){

                L.t(this, "Is triangular and square!");

            } else if (inputNumber.isSquare()){
                L.t(this, "Is square.");
            } else if (inputNumber.isTriangular()){
                L.t(this, "Is triangular.");
            } else {
                L.t(this, "Is neither.");
            }
        }
    }

    public static class Number{

        int number;

        public boolean isTriangular(){
            int count = 0;
            int triangularNumber = 0;
            while (triangularNumber < number){
                triangularNumber = triangularNumber + count;
                count++;
            }
            if (triangularNumber == number) {
                return true;
            }
            return false;
        };

        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot)){
                return true;
            }
            return false;
        };
    }


}
