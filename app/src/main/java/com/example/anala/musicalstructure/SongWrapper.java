// code for wrapper
package com.example.anala.musicalstructure;

import java.io.Serializable;
import java.util.ArrayList;

public class SongWrapper implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Song> songs;

    public SongWrapper(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}