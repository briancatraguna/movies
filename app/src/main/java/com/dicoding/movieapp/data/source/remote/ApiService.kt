package com.dicoding.movieapp.data.source.remote

import com.dicoding.movieapp.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("3/search/movie?api_key=${BuildConfig.MOVIE_TOKEN}&language=en-US&")
    fun getMovies(
            @Query("query") query: String
    ): Call<SearchMovieResponse>

    @GET("3/search/tv?api_key=${BuildConfig.MOVIE_TOKEN}&language=en-US&")
    fun getShows(
            @Query("query") query: String
    ): Call<SearchShowResponse>

    @GET("3/movie/{id}?api_key=${BuildConfig.MOVIE_TOKEN}")
    fun getMovieById(
        @Path("id") id: String
    ):Call<SearchDetailMovieResponse>

    @GET("3/tv/{id}?api_key=${BuildConfig.MOVIE_TOKEN}")
    fun getShowById(
            @Path("id") id: String
    ):Call<SearchDetailShowResponse>
}