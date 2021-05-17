package com.dicoding.movieapp.data.source.local.room.shows

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TvShowsStarredDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(show: TvShowsRoomEntity)

    @Delete
    suspend fun delete(show: TvShowsRoomEntity)

    @Query("SELECT * from starred_show_table ORDER BY id ASC")
    fun getAllShows(): LiveData<List<TvShowsRoomEntity>>
}