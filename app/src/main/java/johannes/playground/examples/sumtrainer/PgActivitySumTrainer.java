package johannes.playground.examples.sumtrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 20.11.16.
 */
public class PgActivitySumTrainer extends PgActivity {

    private Button mButtonPlay = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_sum_trainer);

        mButtonPlay = (Button) findViewById(R.id.buttonPlaySumTrainer);

        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hide play button and start the game
                mButtonPlay.setVisibility(View.INVISIBLE);
                startGame();

            }
        });

    }

    private void startGame() {


    }

    private class GameTimer extends CountDownTimer {

        public GameTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

        }

        @Override
        public void onTick(long l) {

        }

        @Override
        public void onFinish() {

        }
    }
}
