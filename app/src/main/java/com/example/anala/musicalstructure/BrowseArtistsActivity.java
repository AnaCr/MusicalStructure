package com.example.anala.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class BrowseArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);


        //TODO: set click listener for artist_parent_view
        /*//Find view by id
        LinearLayout artist = findViewById(R.id.artist_parent_view);

        //Set onClickListener
        //ArtistActivity will begin when the artist view is clicked
        artist.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ArtistIntent = new Intent(BrowseArtistsActivity.this, ArtistActivity.class);
                startActivity(ArtistIntent);
            }
        });*/

        // List the artists
        ArrayList<Item> Artists = new ArrayList<Item>();
        Artists.add(new Item("Dance Gavin Dance", R.drawable.artist_icon));
        Artists.add(new Item("We The Kings", R.drawable.artist_icon));
        Artists.add(new Item("Smallpools", R.drawable.artist_icon));

        ItemAdapter adapter = new ItemAdapter(this, Artists);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
