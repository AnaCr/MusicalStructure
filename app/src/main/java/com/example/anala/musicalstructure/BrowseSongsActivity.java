package com.example.anala.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BrowseSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_songs);

        // Find the song TextView
        LinearLayout song = findViewById(R.id.song_parent_view);

        // Set onClick listener
        // clicking the song name will open the Now Playing Activity and play that song

        song.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(BrowseSongsActivity.this, NowPlayingActivity.class);

                startActivity(nowPlayingIntent);
                }
        });

        // TODO: Add the songs here using ArrayList


    }
}
