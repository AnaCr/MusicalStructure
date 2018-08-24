package com.example.anala.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class BrowseAlbumsActivity extends AppCompatActivity {

    //Declare variables
    private ArrayList<Item> Albums;
    public static Item currentAlbum;
    public static int currentAlbumIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);

        // get the song wrapper and songs ListArray from Main
        SongWrapper songWrapper = (SongWrapper) getIntent().getSerializableExtra("songsWrapper");
        ArrayList<Song> songs = songWrapper.getSongs();

        // create song wrapper to send songs ListArray to next Activity
        final SongWrapper wrapper = new SongWrapper(songs);

        // List the albums
        Albums = new ArrayList<Item>();
        Albums.add(new Item("Mothership", R.drawable.mothership));
        Albums.add(new Item("Artificial Selection", R.drawable.artificialselection));
        Albums.add(new Item("Neighborhoods", R.drawable.neighborhoods));
        Albums.add(new Item("We The Kings", R.drawable.wtkalbum));
        Albums.add(new Item("Somewhere Somehow", R.drawable.somewhere));
        Albums.add(new Item("Six", R.drawable.six));
        Albums.add(new Item("Lovetap!", R.drawable.lovetap));

        ItemAdapter adapter = new ItemAdapter(this, Albums);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent nowPlayingIntent = new Intent(BrowseAlbumsActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra("FROM_ACTIVITY", "BrowseAlbums");
                nowPlayingIntent.putExtra("currentAlbumIndex", i);
                nowPlayingIntent.putExtra("songsWrapper", wrapper);
                currentAlbumIndex = i;
                currentAlbum = Albums.get(i);
                startActivity(nowPlayingIntent);
            }
        });
    }
}
