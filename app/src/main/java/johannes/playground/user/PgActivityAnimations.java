package johannes.playground.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityAnimations extends PgActivity {

    Button mButtonFade   = null;
    Button mButtonRotate = null;
    Button mButtonDrop   = null;
    Button mButtonResize = null;

    ImageView mImageView = null;

    private static final int animationDuration = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_animations);

        mButtonFade   = (Button) findViewById(R.id.buttonFadeAnimation);
        mButtonRotate = (Button) findViewById(R.id.buttonRotateAnimation);
        mButtonDrop   = (Button) findViewById(R.id.buttonDropAnimation);
        mButtonResize = (Button) findViewById(R.id.buttonResizeAnimation);

        mImageView = (ImageView) findViewById(R.id.imageViewAnimations);

        mImageView.setImageResource(R.drawable.red);

        resetImage();

        mButtonFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start fade animation
                fade();
            }
        });

        mButtonRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start rotate animation
                rotate();
            }
        });


    private void rotate() {
        // Reset and animate image to rotate
        resetImage();
        mImageView.animate().rotation(360f).setDuration(animationDuration);

    }

    private void fade() {
        // Reset and animate image to transparent
        resetImage();
        mImageView.animate().alpha(0f).setDuration(animationDuration);

    }

    private void resetImage() {
        // Set image intransparent
        mImageView.setAlpha(1f);

        // Remove rotation
        mImageView.setRotation(0f);

    }
}
