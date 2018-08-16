package com.example.anala.musicalstructure;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Activity context, ArrayList<Item> Items) {
        super(context, 0, Items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Item currentItem = getItem(position);

        TextView itemNameTextView = listItemView.findViewById(R.id.item_name_text_view);
        itemNameTextView.setText(currentItem.getmItemName());

        ImageView itemDrawableView = listItemView.findViewById(R.id.item_drawable_image_view);
        itemDrawableView.setImageResource(currentItem.getmItemDrawableId());

        return listItemView;
    }
}
