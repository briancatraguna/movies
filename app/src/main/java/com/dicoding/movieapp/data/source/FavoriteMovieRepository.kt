package com.dicoding.movieapp.data.source

import androidx.lifecycle.LiveData
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import com.dicoding.movieapp.data.source.local.room.movies.MoviesStarredDao
import com.dicoding.movieapp.utils.EspressoIdlingResources

class FavoriteMovieRepository(private val movieDao: MoviesStarredDao) {

    val readAllMovies: LiveData<List<MoviesRoomEntity>> = movieDao.getAllMovies()

    fun addMovie(movie: MoviesRoomEntity){
        EspressoIdlingResources.increment()
        movieDao.insert(movie)
        EspressoIdlingResources.decrement()
    }

    fun delMovieById(movieId: Int){
        EspressoIdlingResources.increment()
        movieDao.deleteByMovieId(movieId)
        EspressoIdlingResources.decrement()
    }

}