package com.example.anala.musicalstructure;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Song> songs;
    private SongWrapper wrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // List the songs
        songs = new ArrayList<Song>();
        songs.add(new Song("Young Robot", "Dance Gavin Dance",
                "Mothership", R.drawable.mothership));
        songs.add(new Song("Frozen One", "Dance Gavin Dance",
                "Mothership", R.drawable.mothership));
        songs.add(new Song("Flossie Dickey Bounce", "Dance Gavin Dance",
                "Mothership", R.drawable.mothership));
        songs.add(new Song("Deception", "Dance Gavin Dance",
                "Mothership", R.drawable.mothership));
        songs.add(new Song("Song of Robot", "Dance Gavin Dance",
                "Artificial Selection", R.drawable.artificialselection));
        songs.add(new Song("Suspended in This Disaster", "Dance Gavin Dance",
                "Artificial Selection", R.drawable.artificialselection));
        songs.add(new Song("Care", "Dance Gavin Dance",
                "Artificial Selection", R.drawable.artificialselection));
        songs.add(new Song("Evaporate", "Dance Gavin Dance",
                "Artificial Selection", R.drawable.artificialselection));
        songs.add(new Song("Up All Night", "Blink-182",
                "Neighborhoods", R.drawable.neighborhoods));
        songs.add(new Song("Heart's All Gone", "Blink-182",
                "Neighborhoods", R.drawable.neighborhoods));
        songs.add(new Song("Secret Valentine", "We The Kings",
                "We The Kings", R.drawable.wtkalbum));
        songs.add(new Song("Stay Young", "We The Kings",
                "We The Kings", R.drawable.wtkalbum));
        songs.add(new Song("Whoa", "We The Kings",
                "We The Kings", R.drawable.wtkalbum));
        songs.add(new Song("All Again For You", "We The Kings",
                "We The Kings", R.drawable.wtkalbum));
        songs.add(new Song("Find You There", "We The Kings",
                "Somewhere Somehow", R.drawable.somewhere));
        songs.add(new Song("I Feel Alive", "We The Kings",
                "Somewhere Somehow", R.drawable.somewhere));
        songs.add(new Song("Sad Song", "We The Kings",
                "Somewhere Somehow", R.drawable.somewhere));
        songs.add(new Song("Just Keep Breathing", "We The Kings",
                "Somewhere Somehow", R.drawable.somewhere));
        songs.add(new Song("The Ocean and The Sun", "We The Kings",
                "Six", R.drawable.six));
        songs.add(new Song("Alive", "We The Kings",
                "Six", R.drawable.six));
        songs.add(new Song("I Won't Settle", "We The Kings",
                "Six", R.drawable.six));
        songs.add(new Song("Planes, Trains, & Cars", "We The Kings",
                "Six", R.drawable.six));
        songs.add(new Song("American Love", "Smallpools",
                "Lovetap!", R.drawable.lovetap));
        songs.add(new Song("Dreaming", "Smallpools",
                "Lovetap!", R.drawable.lovetap));
        songs.add(new Song("Karaoke", "Smallpools",
                "Lovetap!", R.drawable.lovetap));
        songs.add(new Song("Street Fight", "Smallpools",
                "Lovetap!", R.drawable.lovetap));
        songs.add(new Song("Lovetap!", "Smallpools",
                "Lovetap!", R.drawable.lovetap));

        // Create wrapper to send ArrayList as intent extra
        wrapper = new SongWrapper(songs);

        // Finds the views by id
        TextView browseSongs = findViewById(R.id.songs_text_view);
        TextView browseArtists = findViewById(R.id.artists_text_view);
        TextView browseAlbums = findViewById(R.id.albums_text_view);

        browseSongs.setOnClickListener(this);
        browseArtists.setOnClickListener(this);
        browseAlbums.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Perform action on click
        switch(v.getId()) {
            case R.id.songs_text_view:
                // create and start the browse songs intent
                Intent browseSongsIntent = new Intent(MainActivity.this, BrowseSongsActivity.class);
                browseSongsIntent.putExtra("songsWrapper", wrapper);
                startActivity(browseSongsIntent);
                break;
            case R.id.artists_text_view:
                // create and start the browse artists intent
                Intent browseArtistsIntent = new Intent(MainActivity.this, BrowseArtistsActivity.class);
                browseArtistsIntent.putExtra("songsWrapper", wrapper);
                startActivity(browseArtistsIntent);
                break;
            case R.id.albums_text_view:
                // create and start the browse albums intent
                Intent browseAlbumsIntent = new Intent(MainActivity.this, BrowseAlbumsActivity.class);
                browseAlbumsIntent.putExtra("songsWrapper", wrapper);
                startActivity(browseAlbumsIntent);
                break;
        }

    }
}
