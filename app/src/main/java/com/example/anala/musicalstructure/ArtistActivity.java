package com.example.anala.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        //Find view by id
        TextView album = findViewById(R.id.album_text_view);
        TextView song = findViewById(R.id.song_text_view);

        //Set onClickListeners
        //AlbumActivity will begin when the album text view is clicked
        album.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AlbumIntent = new Intent(ArtistActivity.this, AlbumActivity.class);
                startActivity(AlbumIntent);
            }
        });

        //NowPlayingActivity will begin when the song text view is clicked
        song.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(ArtistActivity.this, NowPlayingActivity.class);
                startActivity(nowPlayingIntent);
            }
        });
    }
}
