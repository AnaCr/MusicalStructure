package com.example.anala.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class BrowseAlbumsActivity extends AppCompatActivity {

    private ArrayList<Item> Albums;
    public static Item currentAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);

        // List the albums
        Albums = new ArrayList<Item>();
        Albums.add(new Item("Mothership", R.drawable.album_icon));
        Albums.add(new Item("Artificial Selection", R.drawable.album_icon));
        Albums.add(new Item("Neighborhoods", R.drawable.album_icon));
        Albums.add(new Item("We The Kings", R.drawable.album_icon));
        Albums.add(new Item("Sunshine State of Mind", R.drawable.album_icon));
        Albums.add(new Item("Somewhere Somehow", R.drawable.album_icon));
        Albums.add(new Item("Six", R.drawable.album_icon));
        Albums.add(new Item("Lovetap", R.drawable.album_icon));
        Albums.add(new Item("The Science of Letting Go", R.drawable.album_icon));

        ItemAdapter adapter = new ItemAdapter(this, Albums);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                if (i == 0) {
                    Intent albumIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                    albumIntent.putExtra("FROM_ACTIVITY", "BrowseAlbums");
                    // Give it the Song that was clicked
                    currentAlbum = Albums.get(0);
                    startActivityForResult(albumIntent, 0);
                }else if (i == 1) {
                    Intent albumIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                    albumIntent.putExtra("FROM_ACTIVITY", "BrowseAlbums");
                    // Give it the Song that was clicked
                    currentAlbum = Albums.get(1);
                    startActivityForResult(albumIntent, 0);
                }else if (i == 2) {
                    Intent albumIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                    albumIntent.putExtra("FROM_ACTIVITY", "BrowseAlbums");
                    // Give it the Song that was clicked
                    currentAlbum = Albums.get(2);
                    startActivityForResult(albumIntent, 0);
                }
            }
        });
    }
}
