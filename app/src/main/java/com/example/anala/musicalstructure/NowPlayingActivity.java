package com.example.anala.musicalstructure;

import android.media.MediaPlayer;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    //Media Player
    private MediaPlayer mMediaPlayer;

    //For the Play/Pause button
    private boolean isPlaying = true;

    //get the song/artist/album that was clicked
    private Song currentSong = BrowseSongsActivity.currentSong;
    private int currentSongIndex = BrowseSongsActivity.currentSongIndex;
    private Item currentArtist = BrowseArtistsActivity.currentArtist;
    private Item currentAlbum = BrowseAlbumsActivity.currentAlbum;

    //Variables
    private ArrayList<Song> songs;
    private TextView titleTextView;
    private ImageView songImageView;
    private TextView songNameTextView;
    private TextView songArtistTextView;
    private TextView songAlbumTextView;
    private ImageView playPauseButton;
    private ImageView previousButton;
    private ImageView nextButton;
    private ArrayList<Song> songsByCurrentArtist = new ArrayList<>();
    private ArrayList<Song> songsInCurrentAlbum = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //For up navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Check what Activity you are coming from
        String fromActivity = getIntent().getStringExtra("FROM_ACTIVITY");

        // get the song wrapper and songs ListArray from Main
        SongWrapper wrapper = (SongWrapper) getIntent().getSerializableExtra("songsWrapper");
        songs = wrapper.getSongs();

        //find views by id
        titleTextView = findViewById(R.id.title);
        songImageView = findViewById(R.id.song_image_view);
        songNameTextView = findViewById(R.id.song);
        songArtistTextView = findViewById(R.id.artist);
        songAlbumTextView = findViewById(R.id.album);
        playPauseButton = findViewById(R.id.play_pause_button);
        previousButton = findViewById(R.id.previous_button);
        nextButton = findViewById(R.id.next_button);

        // if a song is selected from BrowseSongs
        if (fromActivity.equals("BrowseSongs")) {
            //display the song info
            titleTextView.setText("");
            songImageView.setImageResource(currentSong.getmSongDrawableId());
            songNameTextView.setText(currentSong.getmSongName());
            songArtistTextView.setText(currentSong.getmSongArtist());
            songAlbumTextView.setText(currentSong.getmSongAlbum());

            mMediaPlayer = MediaPlayer.create(NowPlayingActivity.this, R.raw.sample_song);
            mMediaPlayer.start();

            //Functionality of the previous and next buttons
            //setOnClickListener for previous song button
            previousButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (currentSongIndex > 0) {
                        currentSongIndex--;
                        currentSong = songs.get(currentSongIndex);
                        //display the song info
                        songImageView.setImageResource(currentSong.getmSongDrawableId());
                        songNameTextView.setText(currentSong.getmSongName());
                        songArtistTextView.setText(currentSong.getmSongArtist());
                        songAlbumTextView.setText(currentSong.getmSongAlbum());
                    }
                }
            });

            //setOnClickListener for next song button
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (currentSongIndex < songs.size() - 1) {
                        currentSongIndex++;
                        currentSong = songs.get(currentSongIndex);
                        //display the song info
                        songImageView.setImageResource(currentSong.getmSongDrawableId());
                        songNameTextView.setText(currentSong.getmSongName());
                        songArtistTextView.setText(currentSong.getmSongArtist());
                        songAlbumTextView.setText(currentSong.getmSongAlbum());
                    }
                }
            });
        }

        // if an artist is selected from BrowseArtists
        if (fromActivity.equals("BrowseArtists")) {

            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getmSongArtist().equals(currentArtist.getmItemName())) {
                    //add the song to the ArrayList for songs by this artist
                    songsByCurrentArtist.add(songs.get(i));
                }
            }

            // now playing music by currentArtist
            titleTextView.setText("Now Playing Music by:\n" + currentArtist.getmItemName());
            //display the song info for the first song by this artist
            currentSongIndex = 0;
            songImageView.setImageResource(currentArtist.getmItemDrawableId());
            songNameTextView.setText(songsByCurrentArtist.get(currentSongIndex).getmSongName());
            songArtistTextView.setText(songsByCurrentArtist.get(currentSongIndex).getmSongArtist());
            songAlbumTextView.setText(songsByCurrentArtist.get(currentSongIndex).getmSongAlbum());

            //Functionality of the previous and next buttons
            //setOnClickListener for previous song button
            previousButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (currentSongIndex > 0) {
                        currentSongIndex--;

                        // get the previous song by currentArtist & display info
                        songNameTextView.setText(songsByCurrentArtist.get(currentSongIndex).getmSongName());
                        songAlbumTextView.setText(songsByCurrentArtist.get(currentSongIndex).getmSongAlbum());
                    }
                }
            });

            //setOnClickListener for next song button
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (currentSongIndex < songsByCurrentArtist.size() - 1) {
                        currentSongIndex++;

                        // get the next song by currentArtist & display the song info
                        songNameTextView.setText(songsByCurrentArtist.get(currentSongIndex).getmSongName());
                        songAlbumTextView.setText(songsByCurrentArtist.get(currentSongIndex).getmSongAlbum());
                    }
                }
            });
        }

        //if an album is selected from BrowseAlbums
        if(fromActivity.equals("BrowseAlbums")){

            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getmSongAlbum().equals(currentAlbum.getmItemName())) {
                    //add the song to the ArrayList for songs by this artist
                    songsInCurrentAlbum.add(songs.get(i));
                }
            }
            // now playing music from albumThatWasClicked (currentAlbum)
            titleTextView.setText("Now Playing Album : "+ currentAlbum.getmItemName());

            //display the song info for the first song in this album
            currentSongIndex = 0;
            songImageView.setImageResource(currentAlbum.getmItemDrawableId());
            songNameTextView.setText(songsInCurrentAlbum.get(currentSongIndex).getmSongName());
            songArtistTextView.setText(songsInCurrentAlbum.get(currentSongIndex).getmSongArtist());
            songAlbumTextView.setText(songsInCurrentAlbum.get(currentSongIndex).getmSongAlbum());

            //Functionality of the previous and next buttons
            //setOnClickListener for previous song button
            previousButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (currentSongIndex > 0) {
                        currentSongIndex--;

                        // get the previous song by currentArtist & display info
                        songNameTextView.setText(songsInCurrentAlbum.get(currentSongIndex).getmSongName());
                        songAlbumTextView.setText(songsInCurrentAlbum.get(currentSongIndex).getmSongAlbum());
                    }
                }
            });

            //setOnClickListener for next song button
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (currentSongIndex < songsInCurrentAlbum.size() - 1) {
                        currentSongIndex++;

                        // get the next song by currentArtist & display the song info
                        songNameTextView.setText(songsInCurrentAlbum.get(currentSongIndex).getmSongName());
                        songAlbumTextView.setText(songsInCurrentAlbum.get(currentSongIndex).getmSongAlbum());
                    }
                }
            });
        }

        //Set onClick Listener for play pause button
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Alternate between play & pause drawable
                if (!isPlaying) {
                    playPauseButton.setImageDrawable(getResources().getDrawable(R.drawable.pause));
                    isPlaying = true;
                    mMediaPlayer.start();
                } else if (isPlaying) {
                    playPauseButton.setImageDrawable(getResources().getDrawable(R.drawable.play));
                    isPlaying = false;
                    mMediaPlayer.pause();
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
