package com.example.melg.moviedbapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class FavoritesView extends GridLayout {
    public FavoritesView(Context context) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.favs, this, true);
    }


}
