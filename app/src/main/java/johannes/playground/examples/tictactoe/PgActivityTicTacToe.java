package johannes.playground.examples.tictactoe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityTicTacToe extends PgActivity {

    ImageView mImageView = null;

    private static boolean redIsPlaying = true;

    // The status of the board initialized to 2 = all fields being unplaced
    private static int[] mBoardStatus = {
            2,2,2,
            2,2,2,
            2,2,2,
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_tictactoe);

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


    }

    private int getPlayerImage() {
        // Get image for player
        if (redIsPlaying){
            return R.drawable.red;
        }
        return R.drawable.yellow;
    }


    private boolean fieldIsEmpty(int field){
        // Check if field is empty
        if (mBoardStatus[field] == 2){
            return true;
        }
        return false;
    }
}
