package johannes.playground.examples.sumtrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 20.11.16.
 */
public class PgActivitySumTrainer extends PgActivity {

    private Button mButtonPlay = null;

    private TextView mTextViewSum = null;
    private TextView mTextViewScore = null;
    private TextView mTextViewTime = null;

    private GridLayout mContainerAnswers = null;
    private Button[] mAnswerButtons = null;

    private LinearLayout mContainerFinish = null;
    private TextView mTextViewFinalScore = null;

    private GameTimer mTimer = null;

    private static int roundsPlayed = 0;
    private static int correctAnswers = 0;

    private static final int gameTime = 30;
    private static final int maxSummand = 20;

    private static int summandOne = 7;
    private static int summandTwo = 8;
    private static int[] answers = null;
    private static int theCorrectAnswer = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_sum_trainer);

        mButtonPlay = (Button) findViewById(R.id.buttonPlaySumTrainer);

        mTextViewSum = (TextView) findViewById(R.id.textViewQuestionSumTrainer);
        mTextViewScore = (TextView) findViewById(R.id.textViewPointsSumTrainer);
        mTextViewTime = (TextView) findViewById(R.id.textViewTimeRemainingSumTrainer);

        mContainerAnswers = (GridLayout) findViewById(R.id.containerAnswersSumTrainer);
        mContainerFinish = (LinearLayout) findViewById(R.id.containerRoundEndSumTrainer);
        mTextViewFinalScore = (TextView) findViewById(R.id.textViewEndScoreSumTrainer);

        // Build an array of the answer buttons
        mAnswerButtons = new Button[4];
        for (int i = 0; i < mAnswerButtons.length; i++){
            Button button = (Button) mContainerAnswers.getChildAt(i);
            mAnswerButtons[i] = button;

        }

        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hide play button and start the game
                resetGame();
                initGame();
                startNewRound();

            }
        });

    }


    private void resetGame() {
        // Hide play button and score layout
        mContainerFinish.setVisibility(View.INVISIBLE);
        mButtonPlay.setVisibility(View.INVISIBLE);

        // Reset scores
        roundsPlayed = 0;
        correctAnswers = 0;

    }

    private void initGame() {
        // Show answer buttons
        mContainerAnswers.setVisibility(View.VISIBLE);
        startTimer();

    }

    private void startNewRound() {
        // Set score text
        setScoreText();

        // Generate new question and answers
        generateQA();

        // Update views
        showQA();

        roundsPlayed++;
    }

    private void generateQA() {
        // Generate new summands
        summandOne = (int) (Math.random() * maxSummand);
        summandTwo = (int) (Math.random() * maxSummand);

        // Generate an array with random numbers in the possible range
        answers = new int[4];
        for (int i = 0; i < answers.length; i++){
            answers[i] = (int) (Math.random() * maxSummand * 2);
        }

        // Generate a random index for answers array
        theCorrectAnswer = (int) (Math.random() * answers.length);

        // Put correct answer in array at index
        answers[theCorrectAnswer] = summandOne + summandTwo;
    }

    private void showQA() {
        // Show sum question
        mTextViewSum.setText(summandOne + " + " + summandTwo);

        // Show answers in buttons
        for (int i = 0; i < answers.length; i++){
            mAnswerButtons[i].setText(String.valueOf(answers[i]));
            final int position = i;
            mAnswerButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Correct answer
                    if (position == theCorrectAnswer){
                        correctAnswers++;

                    }
                    startNewRound();
                }
            });
        }

    }

    private void setScoreText() {
        // Make string for text view and display
        String text = String.valueOf(correctAnswers) + "/" + String.valueOf(roundsPlayed);
        mTextViewScore.setText(text);

    }

    private void startTimer() {
        // Start the game timer
        mTimer = new GameTimer(gameTime * 1000 + 100, 1000); // Tick is one second
        mTimer.start();
    }

    private void updateTimeView(int secondsRemaining) {
        // Set text of time remaining view
        String text = String.valueOf(secondsRemaining + "s");
        mTextViewTime.setText(text);

    }

    private void finishGame() {
        // Hide answer button
        mContainerAnswers.setVisibility(View.INVISIBLE);

        // Show results layout and play button
        mContainerFinish.setVisibility(View.VISIBLE);
        mButtonPlay.setVisibility(View.VISIBLE);

        // Make string for text view and display
        String text = String.valueOf(correctAnswers) + "/" + String.valueOf(roundsPlayed);
        mTextViewFinalScore.setText(text);

    }

    private class GameTimer extends CountDownTimer {

        public GameTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

        }

        @Override
        public void onTick(long l) {
            updateTimeView((int) l / 1000);

        }

        @Override
        public void onFinish() {
            updateTimeView(0);
            finishGame();

        }
    }
}
