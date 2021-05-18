package com.dicoding.movieapp.data.source

import android.app.Application
import androidx.lifecycle.LiveData
import com.dicoding.movieapp.data.source.local.room.shows.TvShowRoomDatabase
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsStarredDao
import com.dicoding.movieapp.utils.EspressoIdlingResources
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteShowRepository(private val showDao: TvShowsStarredDao) {

    val readAllShows: LiveData<List<TvShowsRoomEntity>> = showDao.getAllShows()

    fun addShows(show: TvShowsRoomEntity){
        showDao.insert(show)
    }

    fun delShowById(showId: Int){
        EspressoIdlingResources.increment()
        showDao.deleteByShowId(showId)
        EspressoIdlingResources.decrement()
    }


}