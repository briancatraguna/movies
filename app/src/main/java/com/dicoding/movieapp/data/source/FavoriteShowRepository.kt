package com.dicoding.movieapp.data.source

import android.app.Application
import androidx.lifecycle.LiveData
import com.dicoding.movieapp.data.source.local.room.shows.TvShowRoomDatabase
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsStarredDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteShowRepository(private val showDao: TvShowsStarredDao) {

    fun readAllShows(): LiveData<List<TvShowsRoomEntity>> = showDao.getAllShows()

    suspend fun addShows(show: TvShowsRoomEntity){
        showDao.insert(show)
    }

    suspend fun delShows(show: TvShowsRoomEntity){
        showDao.delete(show)
    }


}