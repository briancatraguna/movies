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
}