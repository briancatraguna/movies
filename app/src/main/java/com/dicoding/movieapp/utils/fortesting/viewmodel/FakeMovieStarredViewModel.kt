package com.dicoding.movieapp.utils.fortesting.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.fortesting.repository.FakeFavoriteMovieRepository

class FakeMovieStarredViewModel () {

    private var data: MutableLiveData<ArrayList<MoviesRoomEntity>>
    private var repository: FakeFavoriteMovieRepository

    init {
        repository = FakeFavoriteMovieRepository()
        data = repository.getReadAllMovies()
    }

    fun getReadAllMovies(): MutableLiveData<ArrayList<MoviesRoomEntity>> {
        return data
    }

    fun addMovie(){
        repository.addMovie()
    }

    fun delMovieById(){
        repository.delMovieById()
    }

}