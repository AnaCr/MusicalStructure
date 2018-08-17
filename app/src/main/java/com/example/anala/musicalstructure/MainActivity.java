package com.example.anala.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // List the songs
        songs = new ArrayList<Song>();
        songs.add(new Song("Chucky vs. The Giant Tortoise", "Dance Gavin Dance", "Mothership"));
        songs.add(new Song("Young Robot", "Dance Gavin Dance", "Mothership"));
        songs.add(new Song("Frozen One", "Dance Gavin Dance", "Mothership"));
        songs.add(new Song("Flossie Dickey Bounce", "Dance Gavin Dance", "Mothership"));
        songs.add(new Song("Deception", "Dance Gavin Dance", "Mothership"));
        songs.add(new Song("Inspire the Liars", "Dance Gavin Dance", "Mothership"));
        songs.add(new Song("Philosopher King", "Dance Gavin Dance", "Mothership"));
        songs.add(new Song("Here Comes the Winner", "Dance Gavin Dance", "Mothership"));
        songs.add(new Song("Exposed", "Dance Gavin Dance", "Mothership"));
        songs.add(new Song("Betrayed by the Game", "Dance Gavin Dance", "Mothership"));
        songs.add(new Song("Petting Zoo Justice", "Dance Gavin Dance", "Mothership"));
        songs.add(new Song("Man of the Year", "Dance Gavin Dance", "Mothership"));

        final SongWrapper wrapper = new SongWrapper(songs);

        // Finds the views by id
        final TextView browseSongs = findViewById(R.id.songs_text_view);
        TextView browseArtists = findViewById(R.id.artists_text_view);
        TextView browseAlbums = findViewById(R.id.albums_text_view);
        TextView nowPlaying = findViewById(R.id.now_playing_text_view);

        //Set onClick Listener for songs_text_view
        browseSongs.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browseSongsIntent = new Intent(MainActivity.this, BrowseSongsActivity.class);
                browseSongsIntent.putExtra("songsWrapper", wrapper);
                startActivity(browseSongsIntent);
            }
        });

        //Set onClick Listener for artists_text_view
        browseArtists.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browseArtistsIntent = new Intent(MainActivity.this, BrowseArtistsActivity.class);
                browseArtistsIntent.putExtra("songsWrapper", wrapper);
                startActivity(browseArtistsIntent);
            }
        });

        //Set onClick Listener for albums_text_view
        browseAlbums.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browseAlbumsIntent = new Intent(MainActivity.this, BrowseAlbumsActivity.class);
                browseAlbumsIntent.putExtra("songsWrapper", wrapper);
                startActivity(browseAlbumsIntent);
            }
        });

        //Set onClick Listener for nowplaying_text_view
        nowPlaying.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra("FROM_ACTIVITY", "Main");
                nowPlayingIntent.putExtra("songsWrapper", wrapper);
                startActivity(nowPlayingIntent);
            }
        });
    }
}
