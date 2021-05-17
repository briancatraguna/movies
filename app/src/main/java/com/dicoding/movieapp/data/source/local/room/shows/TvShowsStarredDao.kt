package com.dicoding.movieapp.data.source.local.room.shows

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TvShowsStarredDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(show: TvShowsRoomEntity)

    @Delete
    fun delete(show: TvShowsRoomEntity)

    @Query("SELECT * from tvshowsroomentity ORDER BY id ASC")
    fun getAllShows(): LiveData<List<TvShowsRoomEntity>>
}