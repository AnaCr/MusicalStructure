package com.example.anala.musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NowPlayingActivity extends AppCompatActivity {

    //For the Play/Pause button
    public boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        final ImageView playPauseButton = findViewById(R.id.play_pause_button);

        //Set onClick Listener for play pause button
        playPauseButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Alternate between play & pause drawable
                if (!isPlaying){
                    playPauseButton.setImageDrawable(getResources().getDrawable(R.drawable.pause));
                    isPlaying = true;
                }
                else if (isPlaying){
                    playPauseButton.setImageDrawable(getResources().getDrawable(R.drawable.play));
                    isPlaying = false;
                }


            }
        });
    }
}
