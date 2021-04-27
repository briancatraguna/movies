package com.dicoding.movieapp.data.source.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("detail/{id}")
    fun getMovies(
        @Path("id") id: String
    ): Call<SearchMovieResponse>
}