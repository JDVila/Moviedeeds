package com.example.melg.moviedbapp.Backend;

import com.example.melg.moviedbapp.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
//TODO fix retrofit

    // most popular
    @GET("movie/popular?api_key=<<api_key>>&language=en-US&page=1")
    Call<Movie>getMPMovies(@Query("api_key") String apiKey) ;

    //now playing
    @GET("movie/now_playing?api_key=<<api_key>>&language=en-US")
    Call<Movie> getNPMovies(@Query("api_key")  String apiKey);
}
