package com.example.anala.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class BrowseAlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);

        //TODO: set click listener for album_parent_view
        /*// Find view by id
        LinearLayout album = findViewById(R.id.album_parent_view);

        //Set onClickListener
        //AlbumActivity will begin when the album view is clicked
        album.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AlbumIntent = new Intent(BrowseAlbumsActivity.this, AlbumActivity.class);
                startActivity(AlbumIntent);
            }
        });*/
    }
}
