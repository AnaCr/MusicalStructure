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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);

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
