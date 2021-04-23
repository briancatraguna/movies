package com.dicoding.movieapp.detail_movie

import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.MovieDetailEntity
import com.dicoding.movieapp.data.MovieEntity
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.DetailDataDummy

class DetailMovieViewModel:ViewModel() {

    private fun getMovieBasicDetails():ArrayList<MovieEntity>{
        return DataDummy.generateMovies()
    }
    fun getBasicMovieDetailsById(movieId: String):MovieEntity?{
        return getMovieBasicDetails().firstOrNull{
            it.movieId == movieId
        }
    }

    private fun getMovieDetails():ArrayList<MovieDetailEntity>{
        return DetailDataDummy.getMovieDetail()
    }
    fun getDetailsById(movieId: String):MovieDetailEntity?{
        return getMovieDetails().firstOrNull{
            it.movieId == movieId
        }
    }
}