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
    public static int currentSongIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);

        // get the song wrapper and songs ListArray from Main
        SongWrapper songWrapper = (SongWrapper) getIntent().getSerializableExtra("songsWrapper");
        songs = songWrapper.getSongs();
        // create song wrapper to send songs ListArray to next Activity
        final SongWrapper wrapper = new SongWrapper(songs);

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent nowPlayingIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                nowPlayingIntent.putExtra("FROM_ACTIVITY", "BrowseSongs");
                nowPlayingIntent.putExtra("currentSongIndex", i);
                nowPlayingIntent.putExtra("songsWrapper", wrapper);
                currentSong = songs.get(i);
                startActivityForResult(nowPlayingIntent, 0);

                /*if (i == 0) {
                    Intent nowPlayingIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                    nowPlayingIntent.putExtra("FROM_ACTIVITY", "BrowseSongs");
                    nowPlayingIntent.putExtra("currentSongIndex", 0);
                    nowPlayingIntent.putExtra("songsWrapper", wrapper);
                    currentSong = songs.get(0);
                    startActivityForResult(nowPlayingIntent, 0);
                }else if (i == 1) {
                    Intent nowPlayingIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                    nowPlayingIntent.putExtra("FROM_ACTIVITY", "BrowseSongs");
                    nowPlayingIntent.putExtra("currentSongIndex", 1);
                    nowPlayingIntent.putExtra("songsWrapper", wrapper);
                    currentSong = songs.get(1);
                    startActivityForResult(nowPlayingIntent, 0);
                }*/

            }
        });
    }
}
