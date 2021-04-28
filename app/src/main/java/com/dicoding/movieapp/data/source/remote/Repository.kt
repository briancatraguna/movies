package com.dicoding.movieapp.data.source.remote

import androidx.lifecycle.LiveData


class Repository private constructor(private val remoteDataSource: RemoteDataSource){

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteData: RemoteDataSource) =
                instance ?: synchronized(this){
                    instance ?: Repository(remoteData).apply { instance = this }
                }
    }

    fun getMovies(search: String): LiveData<List<MoviesItem>> {
        remoteDataSource.findMovies(search)
        return remoteDataSource.movies
    }
}