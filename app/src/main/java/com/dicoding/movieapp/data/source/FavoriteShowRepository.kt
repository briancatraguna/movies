package com.dicoding.movieapp.data.source

import android.app.Application
import androidx.lifecycle.LiveData
import com.dicoding.movieapp.data.source.local.room.shows.TvShowRoomDatabase
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsStarredDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteShowRepository(application: Application) {
    private val mShowsStarredDao: TvShowsStarredDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = TvShowRoomDatabase.getDatabase(application)
        mShowsStarredDao = db.tvShowsStarredDao()
    }

    fun getAllShows(): LiveData<List<TvShowsRoomEntity>> = mShowsStarredDao.getAllShows()

    fun insert(show: TvShowsRoomEntity){
        executorService.execute { mShowsStarredDao.insert(show) }
    }

    fun delete(show: TvShowsRoomEntity){
        executorService.execute { mShowsStarredDao.delete(show) }
    }

}