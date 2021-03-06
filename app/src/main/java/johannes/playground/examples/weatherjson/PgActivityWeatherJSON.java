package johannes.playground.examples.weatherjson;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import johannes.playground.L;
import johannes.playground.PgActivity;
import johannes.playground.PgImplicitIntentFactory;
import johannes.playground.R;

/**
 * Created by johannesklein on 21.11.16.
 */
public class PgActivityWeatherJSON extends PgActivity {

    private EditText mEditText;
    private TextView mTextView;
    private Button mButton;

    private String baseURL = "http://api.openweathermap.org/data/2.5/weather?q=";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_weather_json);

        mEditText = (EditText) findViewById(R.id.editTextWeather);
        mTextView = (TextView) findViewById(R.id.textViewResultWeather);
        mButton = (Button) findViewById(R.id.buttonWeather);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String city = null;

                if (mEditText.getText().length() != 0){

                    city = mEditText.getText().toString();
                    mTextView.setText(city);

                    String combinedUrl = baseURL + city;
                    new PgImplicitIntentFactory(getApplicationContext()).browserIntent(combinedUrl);

                    // TODO get API key

                } else {
                    L.t(getApplicationContext(), "Please input something.");

                }
            }
        });

    }
}
