package com.example.anala.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BrowseSongsActivity extends AppCompatActivity {

    private ArrayList<Song> songs;
    public static Song currentSong;
    public static String prevousActivity = "BrowseSongsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);

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
        songs.add(new Song("test", "test", "test"));

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                if (i == 0) {
                    Intent nowPlayingIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                    // Give it the Song that was clicked
                    currentSong = songs.get(0);
                    startActivityForResult(nowPlayingIntent, 0);
                }else if (i == 1) {
                    Intent nowPlayingIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                    // Give it the song that was clicked
                    currentSong = songs.get(1);
                    startActivityForResult(nowPlayingIntent, 0);
                }

                //Intent nowPlayingIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                //startActivityForResult(nowPlayingIntent, 0);

            }
        });
    }
}
