package johannes.playground.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.VideoView;
import android.widget.MediaController;


import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityVideo extends PgActivity {

    private VideoView mVideoView = null;

    private MediaController mVideoController = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_video);

        mVideoView = (VideoView) findViewById(R.id.videoViewVideo);

        // Set video file path
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.demovideo;
        mVideoView.setVideoPath(videoPath);

        mVideoController = new MediaController(this);

        // Tie together Video view and media controller
        mVideoController.setAnchorView(mVideoView);
        mVideoView.setMediaController(mVideoController);

        mVideoView.start();
    }
}
