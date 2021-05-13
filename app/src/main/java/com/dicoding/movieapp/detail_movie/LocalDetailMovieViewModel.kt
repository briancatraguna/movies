package com.dicoding.movieapp.detail_movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.source.local.MovieDetailEntity
import com.dicoding.movieapp.data.source.local.MovieEntity
import com.dicoding.movieapp.data.source.Repository

class LocalDetailMovieViewModel(private val repository: Repository):ViewModel() {

    private fun getMovieBasicDetails(): LiveData<List<MovieEntity>> {
        return repository.getLocalMovies()
    }
    fun getBasicMovieDetailsById(movieId: String): MovieEntity?{
        return getMovieBasicDetails().value?.firstOrNull {
            it.movieId == movieId
        }
    }

    private fun getMovieDetails(): LiveData<List<MovieDetailEntity>>{
        return repository.getLocalDetailMovies()
    }
    fun getDetailsById(movieId: String): MovieDetailEntity?{
        return getMovieDetails().value?.firstOrNull {
            it.movieId == movieId
        }
    }
}