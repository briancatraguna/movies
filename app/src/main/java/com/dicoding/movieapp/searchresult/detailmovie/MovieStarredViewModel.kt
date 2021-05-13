package com.dicoding.movieapp.searchresult.detailmovie

import android.app.Application
import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.source.FavoriteMovieRepository
import com.dicoding.movieapp.data.source.local.room.MoviesRoomEntity

class MovieStarredViewModel(application: Application): ViewModel() {
    private val mMovieRepository: FavoriteMovieRepository = FavoriteMovieRepository(application)

    fun insert(movie: MoviesRoomEntity){
        mMovieRepository.insert(movie)
    }

    fun delete(movie: MoviesRoomEntity){
        mMovieRepository.delete(movie)
    }

}