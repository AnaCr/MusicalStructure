package com.example.anala.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //For the Play/Pause button
    public boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finds the views by id
        TextView browseSongs = findViewById(R.id.songs_text_view);
        TextView browseArtists = findViewById(R.id.artists_text_view);
        TextView browseAlbums = findViewById(R.id.albums_text_view);
        TextView nowPlaying = findViewById(R.id.nowplaying_text_view);
        final ImageView playPauseButton = findViewById(R.id.play_pause_button);

        //Set onClick Listener for songs_text_view
        browseSongs.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browseSongsIntent = new Intent(MainActivity.this, BrowseSongsActivity.class);
                startActivity(browseSongsIntent);
            }
        });

        //Set onClick Listener for artists_text_view
        browseArtists.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browseArtistsIntent = new Intent(MainActivity.this, BrowseArtistsActivity.class);
                startActivity(browseArtistsIntent);
            }
        });

        //Set onClick Listener for albums_text_view
        browseAlbums.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browseAlbumsIntent = new Intent(MainActivity.this, BrowseAlbumsActivity.class);
                startActivity(browseAlbumsIntent);
            }
        });

        //Set onClick Listener for nowplaying_text_view
        nowPlaying.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra("FROM_ACTIVITY", "Main");
                startActivity(nowPlayingIntent);
            }
        });

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
