package johannes.playground.examples.tictactoe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityTicTacToe extends PgActivity {

    private LinearLayout mLinearLayout = null;
    private TextView mTextView = null;
    private Button mButton = null;

    private ImageView mImageView = null;

    private static boolean redIsPlaying = true;

    // The status of the board initialized to 2 = all fields being unplaced
    private static int[] mBoardStatus = {
            2,2,2,
            2,2,2,
            2,2,2,
    };

    private static final int[] unplayedBoard = mBoardStatus.clone();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_tictactoe);

        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayoutTicTacToe);
        mTextView = (TextView) findViewById(R.id.textViewTicTacToe);
        mButton = (Button) findViewById(R.id.mButtonPlayTicTacToe);

    }


    public void dropIn(View view) {
        // Get the clicked view
        mImageView = (ImageView) view;

        int tappedView = Integer.parseInt(mImageView.getTag().toString());

        if (!fieldIsEmpty(tappedView)) {
            return;

        }

        // Move image off screen and animate drop
        mImageView.setImageResource(getPlayerImage());
        mImageView.setTranslationY(-1000f);
        mImageView.animate().translationYBy(1000f).setDuration(400);

        // Set the status of the current field to the player status
        mBoardStatus[tappedView] = getPlayer();

        // Switch turns
        redIsPlaying = !redIsPlaying;

        if (checkIfDraw()) {
            mTextView.setText("It's a draw!");
            gameOver();

        }
    }

    private void resetBoard() {
        // Remove images
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayoutTicTacToe);
        for (int i = 0; i< gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

        // Reset board status
        mBoardStatus = unplayedBoard.clone();
    }

    private boolean checkIfDraw() {
        // Check if there is a draw
        for (int field : mBoardStatus){
            if (field == 2){
                return false;
            }
        }
        return true;
    }

    private int getPlayerImage() {
        // Get image for player
        if (redIsPlaying){
            return R.drawable.red;
        }
        return R.drawable.yellow;
    }

    private int getPlayer() {
        // Get player
        if (redIsPlaying){
            return 0;
        }
        return 1;
    }

    private boolean fieldIsEmpty(int field){
        // Check if field is empty
        if (mBoardStatus[field] == 2){
            return true;
        }
        return false;
    }

    private void gameOver(){
        // Show game Over message
        mLinearLayout.setVisibility(View.VISIBLE);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBoard();
                mLinearLayout.setVisibility(View.INVISIBLE);
            }
        });


    }
}
