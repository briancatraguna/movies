package com.dicoding.movieapp.searchresult.detailmovie

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.movieapp.data.source.FavoriteMovieRepository
import com.dicoding.movieapp.data.source.local.room.movies.MovieRoomDatabase
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieStarredViewModel(application: Application): ViewModel() {

    val readAllMovies: LiveData<List<MoviesRoomEntity>>
    private val repository: FavoriteMovieRepository

    init {
        val movieDao = MovieRoomDatabase.getDatabase(application).moviesStarredDao()
        repository = FavoriteMovieRepository(movieDao)
        readAllMovies = repository.readAllMovies
    }

    fun addMovie(movie: MoviesRoomEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.addMovie(movie)
        }
    }

    fun delMovieById(movieId: Int){
        viewModelScope.launch(Dispatchers.IO){
            repository.delMovieById(movieId)
        }
    }

}