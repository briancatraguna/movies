package com.dicoding.movieapp.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.source.local.MovieEntity
import com.dicoding.movieapp.data.source.Repository

class MovieViewModel(private val repository: Repository):ViewModel() {

    fun getMovies(): LiveData<List<MovieEntity>> {
        return repository.getLocalMovies()
    }
}