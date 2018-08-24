package com.example.anala.musicalstructure;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemWrapper implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Item> items;

    public ItemWrapper(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItem() {
        return items;
    }
}
