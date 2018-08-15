package com.example.anala.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class BrowseArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_artists);

        //Find view by id
        LinearLayout artist = findViewById(R.id.artist_parent_view);

        //Set onClickListener
        //ArtistActivity will begin when the artist view is clicked
        artist.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ArtistIntent = new Intent(BrowseArtistsActivity.this, ArtistActivity.class);
                startActivity(ArtistIntent);
            }
        });
    }
}
