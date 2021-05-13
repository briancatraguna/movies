package com.dicoding.movieapp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface TvShowsStarredDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(show: TvShowsRoomEntity)

    @Delete
    fun delete(show: TvShowsRoomEntity)

    @Query("SELECT * from tvshowsroomentity ORDER BY id ASC")
    fun getAllMovies(): LiveData<List<TvShowsRoomEntity>>
}