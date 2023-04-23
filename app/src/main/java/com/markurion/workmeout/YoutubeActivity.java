package com.markurion.workmeout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class YoutubeActivity extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerOne,youTubePlayerTwo,youTubePlayerThree,youTubePlayerFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        getSupportActionBar().setTitle("Recommended Youtube Videos");

        youTubePlayerOne = findViewById(R.id.youtube_player_one);
        youTubePlayerTwo = findViewById(R.id.youtube_player_two);
        youTubePlayerThree = findViewById(R.id.youtube_player_three);
        youTubePlayerFour = findViewById(R.id.youtube_player_four);
        getLifecycle().addObserver(youTubePlayerOne);
        getLifecycle().addObserver(youTubePlayerTwo);
        getLifecycle().addObserver(youTubePlayerThree);
        getLifecycle().addObserver(youTubePlayerFour);

        Useful.placeYT(youTubePlayerOne,"62GbYo1akJg",false);
        Useful.placeYT(youTubePlayerTwo,"yMyO-JfQuDU",false);
        Useful.placeYT(youTubePlayerThree,"9zftzzJ-Mak",false);
        Useful.placeYT(youTubePlayerFour,"QmOF0crdyRU",false);
    }

}