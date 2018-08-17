package com.example.anala.musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    //For the Play/Pause button
    public boolean isPlaying = false;

    Song currentSong = BrowseSongsActivity.currentSong;
    //int currentSongIndex = BrowseSongsActivity.currentSongIndex;
    int currentSongIndex;
    private ArrayList<Song> songs;

    //find views
    ImageView songImageView;
    TextView songNameTextView;
    TextView songArtistTextView;
    TextView songAlbumTextView;
    ImageView playPauseButton;
    ImageView previousButton;
    ImageView nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //Check what Activity you are coming from
        String fromActivity = getIntent().getStringExtra("FROM_ACTIVITY");

        // get the song wrapper and songs ListArray from Main
        SongWrapper wrapper = (SongWrapper) getIntent().getSerializableExtra("songsWrapper");
        songs = wrapper.getSongs();

        //Initiate views
        songImageView = findViewById(R.id.song_image_view);
        songNameTextView = findViewById(R.id.song);
        songArtistTextView = findViewById(R.id.artist);
        songAlbumTextView = findViewById(R.id.album);
        playPauseButton = findViewById(R.id.play_pause_button);
        previousButton = findViewById(R.id.previous_button);
        nextButton = findViewById(R.id.next_button);

        // if a song is selected from BrowseSongs
        if(fromActivity.equals("BrowseSongs")){
            //display the song info
            songNameTextView.setText(currentSong.getmSongName());
            songArtistTextView.setText("Artist: " + currentSong.getmSongArtist());
            songAlbumTextView.setText("Album: " + currentSong.getmSongAlbum());

            //Functionality of the previous and next buttons
            //setOnClickListener for previous song button
            previousButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(currentSongIndex > 0){
                        currentSongIndex--;
                        currentSong = songs.get(currentSongIndex);
                        Log.i("current song", currentSong.getmSongName());
                        //display the song info
                        songNameTextView.setText(currentSong.getmSongName());
                        songArtistTextView.setText("Artist: " + currentSong.getmSongArtist());
                        songAlbumTextView.setText("Album: " + currentSong.getmSongAlbum());
                    }
                }
            });

            //setOnClickListener for next song button
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(currentSongIndex < songs.size()-1){
                        currentSongIndex++;
                        currentSong = songs.get(currentSongIndex);
                        Log.i("current song", currentSong.getmSongName());
                        //display the song info
                        songNameTextView.setText(currentSong.getmSongName());
                        songArtistTextView.setText("Artist: " + currentSong.getmSongArtist());
                        songAlbumTextView.setText("Album: " + currentSong.getmSongAlbum());
                    }
                }
            });
        }
        //TODO: if FROM_ACTIVITY = browse artists
        // now playing music by artistThatWasClicked (currentArtist)

        //TODO: if FROM-ACTIVITY = browse albums
        // now playing music from albumThatWasClicked (currentAlbum)

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
