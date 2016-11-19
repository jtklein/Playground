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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_tictactoe);

    }


    public void dropIn(View view) {

        mImageView = (ImageView) view;

        int tappedView = Integer.parseInt(mImageView.getTag().toString());

        mImageView.setTranslationY(-1000f);

        mImageView.setImageResource(R.drawable.red);

        mImageView.animate().translationYBy(1000f).setDuration(400);


    }
}
