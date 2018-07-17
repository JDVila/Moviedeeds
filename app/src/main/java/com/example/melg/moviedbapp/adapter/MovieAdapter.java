package com.example.melg.moviedbapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.melg.moviedbapp.R;
import com.example.melg.moviedbapp.controller.MovieViewHolder;
import com.example.melg.moviedbapp.model.Movie;
import com.example.melg.moviedbapp.model.Results;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    List<Results> movieList;

    public MovieAdapter(List<Results> movieList) {
        this.movieList = movieList;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_view, parent, false);
        return new MovieViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Results movie = movieList.get(position);

        holder.onBind(movie);




    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
