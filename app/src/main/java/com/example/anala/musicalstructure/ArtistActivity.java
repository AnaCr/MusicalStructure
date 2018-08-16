package com.example.anala.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        //Find view by id
        TextView albumTextView = findViewById(R.id.album_text_view);
        TextView songTextView = findViewById(R.id.song_text_view);
        ImageView artistImageView = findViewById(R.id.artist_image_view);
        TextView artistNameTextView = findViewById(R.id.artist_name_text_view);

        //set text and image
        artistNameTextView.setText(BrowseArtistsActivity.currentArtist.getmItemName());
        artistImageView.setImageResource(BrowseArtistsActivity.currentArtist.getmItemDrawableId());

        //Set onClickListeners
        //AlbumActivity will begin when the album text view is clicked
        albumTextView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AlbumIntent = new Intent(ArtistActivity.this, AlbumActivity.class);
                startActivity(AlbumIntent);
            }
        });

        //NowPlayingActivity will begin when the song text view is clicked
        songTextView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(ArtistActivity.this, NowPlayingActivity.class);
                startActivity(nowPlayingIntent);
            }
        });
    }
}
