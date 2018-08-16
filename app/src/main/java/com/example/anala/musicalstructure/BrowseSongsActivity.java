package com.example.anala.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BrowseSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);

        // Find the song TextView
        ListView song = findViewById(R.id.list);

        // Set onClick listener
        // clicking the song name will open the Now Playing Activity and play that song

        /*song.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(BrowseSongsActivity.this, NowPlayingActivity.class);

                startActivity(nowPlayingIntent);
                }
        });*/

        // List the songs
        ArrayList<Song> songs = new ArrayList<Song>();
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

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent nowPlayingIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                startActivityForResult(nowPlayingIntent, 0);

            }
        });
    }
}
