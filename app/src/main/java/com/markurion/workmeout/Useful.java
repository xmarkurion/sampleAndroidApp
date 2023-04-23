package com.markurion.workmeout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class Useful {

    /**
     * Create an custom yt view with those parms
     * @param plView Point to active yt windoiw
     * @param idOfVideo Youtube id
     * @param autoplay True or false
     */
    public static void placeYT(YouTubePlayerView plView, String idOfVideo, boolean autoplay){
        plView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = idOfVideo;
                if(autoplay) youTubePlayer.loadVideo(videoId, 0);
                else youTubePlayer.cueVideo(videoId, 0);
            }
        });
    }
}
