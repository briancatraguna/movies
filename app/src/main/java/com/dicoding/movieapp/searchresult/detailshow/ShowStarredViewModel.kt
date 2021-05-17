package com.dicoding.movieapp.searchresult.detailshow

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.movieapp.data.source.FavoriteShowRepository
import com.dicoding.movieapp.data.source.local.room.shows.TvShowRoomDatabase
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowStarredViewModel(application: Application): ViewModel() {

    val readAllShows: LiveData<List<TvShowsRoomEntity>>
    private val repository: FavoriteShowRepository

    init {
        val showDao = TvShowRoomDatabase.getDatabase(application).tvShowsStarredDao()
        repository = FavoriteShowRepository(showDao)
        readAllShows = repository.readAllShows()
    }

    fun addShow(show: TvShowsRoomEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.addShows(show)
        }
    }

    fun delShow(show: TvShowsRoomEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.delShows(show)
        }
    }


}