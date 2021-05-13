package com.dicoding.movieapp.data.source

import android.app.Application
import androidx.lifecycle.LiveData
import com.dicoding.movieapp.data.source.local.room.MovieRoomDatabase
import com.dicoding.movieapp.data.source.local.room.MoviesRoomEntity
import com.dicoding.movieapp.data.source.local.room.MoviesStarredDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteMovieRepository(application: Application) {
    private val mMoviesStarredDao: MoviesStarredDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = MovieRoomDatabase.getDatabase(application)
        mMoviesStarredDao = db.moviesStarredDao()
    }

    fun getAllMovies(): LiveData<List<MoviesRoomEntity>> = mMoviesStarredDao.getAllMovies()

    fun insert(movie: MoviesRoomEntity){
        executorService.execute { mMoviesStarredDao.insert(movie) }
    }

    fun delete(movie: MoviesRoomEntity){
        executorService.execute { mMoviesStarredDao.delete(movie) }
    }

}