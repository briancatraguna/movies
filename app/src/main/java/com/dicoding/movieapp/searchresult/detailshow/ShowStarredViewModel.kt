package com.dicoding.movieapp.searchresult.detailshow

import android.app.Application
import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.source.FavoriteShowRepository
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity

class ShowStarredViewModel(application: Application): ViewModel() {
    private val mShowRepository: FavoriteShowRepository = FavoriteShowRepository(application)

    fun insert(show: TvShowsRoomEntity){
        mShowRepository.insert(show)
    }

    fun delete(show: TvShowsRoomEntity){
        mShowRepository.delete(show)
    }

    fun isShowStarred(show: TvShowsRoomEntity): Boolean{
        val allShows = mShowRepository.getAllShows().value
        if (allShows?.contains(show) == true){
            return true
        }
        return false
    }


}