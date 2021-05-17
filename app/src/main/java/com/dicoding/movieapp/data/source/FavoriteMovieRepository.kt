package com.dicoding.movieapp.data.source

import android.app.Application
import androidx.lifecycle.LiveData
import com.dicoding.movieapp.data.source.local.room.MovieRoomDatabase
import com.dicoding.movieapp.data.source.local.room.MoviesRoomEntity
import com.dicoding.movieapp.data.source.local.room.MoviesStarredDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteMovieRepository(private val movieDao: MoviesStarredDao) {

    val readAllMovies: LiveData<List<MoviesRoomEntity>> = movieDao.getAllMovies()

    suspend fun addMovie(movie: MoviesRoomEntity){
        movieDao.insert(movie)
    }

    suspend fun delMovie(movie: MoviesRoomEntity){
        movieDao.delete(movie)
    }

}