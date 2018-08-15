package com.example.anala.musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> Songs) {
        super(context, 0, Songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_song, parent, false);
        }

        Song currentSong = getItem(position);

        TextView songNameTextView = listItemView.findViewById(R.id.song_text_view);
        songNameTextView.setText(currentSong.getmSongName());

        TextView songArtistTextView = listItemView.findViewById(R.id.artist_text_view);
        songArtistTextView.setText(currentSong.getmSongArtist());

        TextView songAlbumTextView = listItemView.findViewById(R.id.album_text_view);
        songAlbumTextView.setText(currentSong.getmSongAlbum());

        return listItemView;
    }

}
