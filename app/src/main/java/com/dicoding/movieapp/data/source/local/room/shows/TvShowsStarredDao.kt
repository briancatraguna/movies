package com.dicoding.movieapp.data.source.local.room.shows

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TvShowsStarredDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(show: TvShowsRoomEntity)

    @Query("DELETE FROM starred_show_table WHERE showId = :show_id")
    fun deleteByShowId(show_id: Int)

    @Query("SELECT * from starred_show_table ORDER BY id ASC")
    fun getAllShows(): LiveData<List<TvShowsRoomEntity>>
}