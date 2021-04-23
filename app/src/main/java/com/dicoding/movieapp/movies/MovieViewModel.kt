package com.dicoding.movieapp.movies

import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.MovieEntity
import com.dicoding.movieapp.utils.DataDummy

class MovieViewModel:ViewModel() {

    fun getMovies(): ArrayList<MovieEntity>{
        return DataDummy.generateMovies()
    }
}