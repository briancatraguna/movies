package com.dicoding.movieapp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface MoviesStarredDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(movie: MoviesRoomEntity)

    @Delete
    fun delete(movie: MoviesRoomEntity)

    @Query("SELECT * from moviesroomentity ORDER BY id ASC")
    fun getAllMovies(): LiveData<List<MoviesRoomEntity>>
}