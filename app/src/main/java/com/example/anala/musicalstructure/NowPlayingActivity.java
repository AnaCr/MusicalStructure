package com.example.anala.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        //find views
        TextView titleTextView = findViewById(R.id.title_text_view);
        ImageView imageView = findViewById(R.id.image_view);
        TextView songNameTextView = findViewById(R.id.song);
        TextView songArtistTextView = findViewById(R.id.artist);
        TextView songAlbumTextView = findViewById(R.id.album);

        //Checking what was the previous activity and getting extra
        Intent intent = getIntent();
        String previousActivity = intent.getStringExtra("FROM_ACTIVITY");
        Log.i("previous activity", intent.getStringExtra("FROM_ACTIVITY"));

        if (previousActivity.equals("BrowseSongs") || previousActivity.equals("Main")) {
            //Display Song info
            //TODO: make title blank
            songNameTextView.setText(BrowseSongsActivity.currentSong.getmSongName());
            songArtistTextView.setText("Artist: " + BrowseSongsActivity.currentSong.getmSongArtist());
            songAlbumTextView.setText("Album: " + BrowseSongsActivity.currentSong.getmSongAlbum());
        }else if (previousActivity.equals("BrowseArtists")){
            //Display Artist Info
            titleTextView.setText("Now Playing Music by: " + BrowseArtistsActivity.currentArtist.getmItemName());
            imageView.setImageResource(BrowseArtistsActivity.currentArtist.getmItemDrawableId());
            songNameTextView.setText("");
            songArtistTextView.setText("");
            songAlbumTextView.setText("");
        }else if (previousActivity.equals("BrowseAlbums")){
            //Display Artist Info
            titleTextView.setText("Now Playing Music from: " + BrowseAlbumsActivity.currentAlbum.getmItemName());
            imageView.setImageResource(BrowseAlbumsActivity.currentAlbum.getmItemDrawableId());
            songNameTextView.setText("");
            songArtistTextView.setText("");
            songAlbumTextView.setText("");
        }

        final ImageView playPauseButton = findViewById(R.id.play_pause_button);

        //Set onClick Listener for play pause button
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Alternate between play & pause drawable
                if (!isPlaying) {
                    playPauseButton.setImageDrawable(getResources().getDrawable(R.drawable.pause));
                    isPlaying = true;
                } else if (isPlaying) {
                    playPauseButton.setImageDrawable(getResources().getDrawable(R.drawable.play));
                    isPlaying = false;
                }


            }
        });
    }
}
