package com.example.melg.moviedbapp.controller;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.melg.moviedbapp.R;
import com.example.melg.moviedbapp.model.Results;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    // @BindView(R.id.movie_imageview)
    ImageView imageView;
    //@BindView(R.id.movie_title)
    TextView movie_title;

    private static final String BeginningOfURL = "https://image.tmdb.org/t/p/w342/";


    public MovieViewHolder(View itemView) {
        super(itemView);


        imageView = itemView.findViewById(R.id.movie_imageview);
        movie_title = itemView.findViewById(R.id.movie_title);


    }

    public void onBind(Results movie) {
        movie_title.setText(movie.getTitle());

        Picasso.get().load(BeginningOfURL + movie.getPoster_path().toString()).resize(400,560).into(imageView);

    }
}


