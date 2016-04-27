package simonsays.sevenprinciples.com.simonsays;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by manuel on 26.04.16.
 */
public class Sound {

    private static MediaPlayer mPlayer;

    public static void playSound(Context context, int soundResource) {
        // play sound
        if(mPlayer != null) {
            if (mPlayer.isPlaying()) {
                mPlayer.stop();
            }
            mPlayer.reset();
            mPlayer.release();
            mPlayer = null;
        }

        mPlayer = MediaPlayer.create(context, soundResource);
        mPlayer.start();
    }
}
