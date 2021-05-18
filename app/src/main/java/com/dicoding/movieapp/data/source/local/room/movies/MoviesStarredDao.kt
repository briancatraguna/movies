package com.dicoding.movieapp.data.source.local.room.movies

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MoviesStarredDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: MoviesRoomEntity)

    @Query("DELETE FROM starred_movie_table WHERE movieId = :movie_id")
    fun deleteByMovieId(movie_id: Int)

    @Query("SELECT * FROM starred_movie_table ORDER BY id ASC")
    fun getAllMovies(): LiveData<List<MoviesRoomEntity>>
}