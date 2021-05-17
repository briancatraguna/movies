package com.dicoding.movieapp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MoviesStarredDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: MoviesRoomEntity)

    @Delete
    suspend fun delete(movie: MoviesRoomEntity)

    @Query("SELECT * FROM starred_movie_table ORDER BY id ASC")
    fun getAllMovies(): LiveData<List<MoviesRoomEntity>>
}