package com.dicoding.movieapp.utils.fortesting.repository

import androidx.lifecycle.MutableLiveData
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
import com.dicoding.movieapp.utils.DataDummy

class FakeFavoriteShowsRepository {

    private var data: MutableLiveData<ArrayList<TvShowsRoomEntity>>

    init {
        val shows = DataDummy.getFakeShowRoomDatabase()
        data = MutableLiveData<ArrayList<TvShowsRoomEntity>>()
        data.value = shows
    }

    fun readAllShows(): MutableLiveData<ArrayList<TvShowsRoomEntity>>{
        return data
    }

    fun addShows(){
        data.value?.add(DataDummy.getTvShowRoomEntity())
    }

    fun delShowById(){
        data.value?.removeAt(0)
    }

}