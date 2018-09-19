package com.example.anala.musicalstructure;

import java.io.Serializable;

public class Song implements Serializable {

    // song name
    private String mSongName;

    // song artist
    private String mSongArtist;

    // song album
    private String mSongAlbum;

    // drawable id
    private int mSongDrawableId;

    // mp3 file id
    private int mSongAudioFileId;

    /**
     * Create a new Song object.
     *
     * @param songName is the name of the song
     * @param songArtist is the artist
     * @param songAlbum is the album
     * @param songDrawableId is the id of the drawable
     * @param songAudioFileId is the mp3 file id
     */
    public Song (String songName, String songArtist, String songAlbum, int songDrawableId, int songAudioFileId) {
        mSongName = songName;
        mSongArtist = songArtist;
        mSongAlbum = songAlbum;
        mSongDrawableId = songDrawableId;
        mSongAudioFileId = songAudioFileId;
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

    // get the drawable Id
    public int getmSongDrawableId() { return mSongDrawableId;}

    // get the mp3 file Id
    public int getmSongAudioFileId(){ return mSongAudioFileId;}

}
