package com.example.anala.musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    //For the Play/Pause button
    public boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);


        /*//find views
        TextView songNameTextView = findViewById(R.id.song);
        TextView songArtistTextView = findViewById(R.id.artist);
        TextView songAlbumTextView = findViewById(R.id.album);

        //set text
        songNameTextView.setText(BrowseSongsActivity.currentSong.getmSongName());
        songArtistTextView.setText("Artist: " + BrowseSongsActivity.currentSong.getmSongArtist());
        songAlbumTextView.setText("Album: " + BrowseSongsActivity.currentSong.getmSongAlbum());*/

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
