package com.dicoding.movieapp.searchresult.detailshow

import android.app.Application
import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.source.FavoriteMovieRepository
import com.dicoding.movieapp.data.source.FavoriteShowRepository
import com.dicoding.movieapp.data.source.local.room.TvShowsRoomEntity

class ShowStarredViewModel(application: Application): ViewModel() {
    private val mShowRepository: FavoriteShowRepository = FavoriteShowRepository(application)

    fun insert(show: TvShowsRoomEntity){
        mShowRepository.insert(show)
    }

    fun delete(show: TvShowsRoomEntity){
        mShowRepository.delete(show)
    }


}