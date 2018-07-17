package com.example.melg.moviedbapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.melg.moviedbapp.Backend.MovieService;
import com.example.melg.moviedbapp.adapter.MovieAdapter;
import com.example.melg.moviedbapp.model.Movie;
import com.example.melg.moviedbapp.model.Results;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;


public class HomeView extends LinearLayout {

    List<Results> movieNpList = new ArrayList<>();
    List<Results> movieMpList = new ArrayList<>();

//    @BindView(R.id.most_pop)
    RecyclerView mpRecView;
//    @BindView(R.id.now_playing)
    RecyclerView npRecView;

    public HomeView(Context context) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.home_view, this, true);
    }

    public HomeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
//        ButterKnife.bind(this);

        setMovieMpList();
        setMovieNpList();





}

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        npRecView = findViewById(R.id.now_playing);
        MovieAdapter npmovieAdapter = new MovieAdapter(movieNpList);
        LinearLayoutManager nplinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL ,false);
        npRecView.setAdapter(npmovieAdapter);
        npRecView.setLayoutManager(nplinearLayoutManager);


        mpRecView = findViewById(R.id.most_pop);
        MovieAdapter mpmovieAdapter = new MovieAdapter(movieMpList);
        LinearLayoutManager mplinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL ,false);
        mpRecView.setAdapter(mpmovieAdapter);
        mpRecView.setLayoutManager(mplinearLayoutManager);


    }









public void setMovieMpList() {
    String url = "https://api.themoviedb.org/3/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    MovieService movieService = retrofit.create(MovieService.class);

    movieService.getMPMovies("297d8ca61347ded7bf23cc719e3e65c2").enqueue(new Callback<Movie>() {
        @Override
        public void onResponse(Call<Movie> call, Response<Movie> response) {
            Log.d(TAG, "onResponse: " + response.body().getResults().get(0).getTitle().toString());
            movieMpList.clear();
            movieMpList.addAll(response.body().getResults());
        }

        @Override
        public void onFailure(Call<Movie> call, Throwable t) {
            t.getMessage();

        }
    });


}
public void setMovieNpList (){
    String url = "https://api.themoviedb.org/3/";

    Retrofit NPretrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    MovieService movieNPService = NPretrofit.create(MovieService.class);
    movieNPService.getNPMovies("297d8ca61347ded7bf23cc719e3e65c2").enqueue(new Callback<Movie>() {
        @Override
        public void onResponse(Call<Movie> call, Response<Movie> response) {
         movieNpList.addAll(response.body().getResults());
        }

        @Override
        public void onFailure(Call<Movie> call, Throwable t) {
            t.getMessage();

        }
    });





}

}
