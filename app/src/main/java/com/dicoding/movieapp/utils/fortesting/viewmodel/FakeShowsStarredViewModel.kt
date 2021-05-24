package com.dicoding.movieapp.utils.fortesting.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
import com.dicoding.movieapp.utils.fortesting.repository.FakeFavoriteShowsRepository

class FakeShowsStarredViewModel {

    private var data: MutableLiveData<ArrayList<TvShowsRoomEntity>>
    private var repository: FakeFavoriteShowsRepository

    init {
        repository = FakeFavoriteShowsRepository()
        data = repository.readAllShows()
    }

    fun readAllShows(): MutableLiveData<ArrayList<TvShowsRoomEntity>> {
        return data
    }

    fun addShow(){
        repository.addShows()
    }

    fun delShowById(){
        repository.delShowById()
    }

}