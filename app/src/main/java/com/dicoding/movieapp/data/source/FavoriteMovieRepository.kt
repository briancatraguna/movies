package com.dicoding.movieapp.data.source

import androidx.lifecycle.LiveData
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import com.dicoding.movieapp.data.source.local.room.movies.MoviesStarredDao

class FavoriteMovieRepository(private val movieDao: MoviesStarredDao) {

    val readAllMovies: LiveData<List<MoviesRoomEntity>> = movieDao.getAllMovies()

    suspend fun addMovie(movie: MoviesRoomEntity){
        movieDao.insert(movie)
    }

    suspend fun delMovie(movie: MoviesRoomEntity){
        movieDao.delete(movie)
    }

}