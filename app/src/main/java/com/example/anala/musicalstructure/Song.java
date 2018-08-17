package com.example.anala.musicalstructure;

import java.io.Serializable;

public class Song implements Serializable {

    // song name
    private String mSongName;

    // song artist
    private String mSongArtist;

    // song album
    private String mSongAlbum;

    /**
     * Create a new Song object.
     *
     * @param songName is the name of the song
     * @param songArtist is the artist
     * @param songAlbum is the album
     */
    public Song (String songName, String songArtist, String songAlbum) {
        mSongName = songName;
        mSongArtist = songArtist;
        mSongAlbum = songAlbum;
    }

    // get the name of the song
    public String getmSongName() {
        return mSongName;
    }

    // get the artist of the song
    public String getmSongArtist() {
        return mSongArtist;
    }

    // get the album of the song
    public String getmSongAlbum() {
        return mSongAlbum;
    }

}
