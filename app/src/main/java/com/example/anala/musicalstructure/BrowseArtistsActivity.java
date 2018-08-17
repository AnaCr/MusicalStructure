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

import java.util.ArrayList;

public class BrowseArtistsActivity extends AppCompatActivity {

    private ArrayList<Item> Artists;
    public static Item currentArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);

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

                if (i == 0) {
                    Intent artistIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                    artistIntent.putExtra("FROM_ACTIVITY", "BrowseArtists");
                    // Give it the Song that was clicked
                    currentArtist = Artists.get(0);
                    startActivityForResult(artistIntent, 0);
                }else if (i == 1) {
                    Intent artistIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                    artistIntent.putExtra("FROM_ACTIVITY", "BrowseArtists");
                    // Give it the Song that was clicked
                    currentArtist = Artists.get(1);
                    startActivityForResult(artistIntent, 0);
                }else if (i == 2) {
                    Intent artistIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                    artistIntent.putExtra("FROM_ACTIVITY", "BrowseArtists");
                    // Give it the Song that was clicked
                    currentArtist = Artists.get(2);
                    startActivityForResult(artistIntent, 0);
                }
            }
        });
    }
}
