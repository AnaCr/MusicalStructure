package com.example.anala.musicalstructure;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class BrowseArtistsActivity extends AppCompatActivity {

    private ArrayList<Item> Artists;
    public static Item currentArtist;
    private ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);

        // get the song wrapper and songs ListArray from Main
        SongWrapper songWrapper = (SongWrapper) getIntent().getSerializableExtra("songsWrapper");
        songs = songWrapper.getSongs();
        // create song wrapper to send songs ListArray to next Activity
        final SongWrapper wrapper = new SongWrapper(songs);

        // List the artists
        Artists = new ArrayList<Item>();
        Artists.add(new Item("Dance Gavin Dance", R.drawable.artist_icon));
        Artists.add(new Item("We The Kings", R.drawable.artist_icon));
        Artists.add(new Item("Smallpools", R.drawable.artist_icon));

        ItemAdapter adapter = new ItemAdapter(this, Artists);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent nowPlayingIntent = new Intent(BrowseArtistsActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra("FROM_ACTIVITY", "BrowseArtists");
                nowPlayingIntent.putExtra("songsWrapper", wrapper);
                startActivity(nowPlayingIntent);
            }
        });
    }
}
