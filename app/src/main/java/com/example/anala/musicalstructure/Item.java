package com.example.anala.musicalstructure;

import java.io.Serializable;

public class Item implements Serializable{

    private static final long serialVersionUID = 1L;

    // Item name
    private String mItemName;

    // Drawable ID
    private int mItemDrawableId;

    /**
     * Create a new Item object.
     *
     * @param itemName is the name of the item
     * @param itemDrawableId is the id of the corresponding drawable
     */
    public Item(String itemName, int itemDrawableId) {
        mItemName = itemName;
        mItemDrawableId = itemDrawableId;
    }

    // get the item's name
    public String getmItemName() {
        return mItemName;
    }

    // get the drawable id
    public int getmItemDrawableId() {
        return mItemDrawableId;
    }
}
