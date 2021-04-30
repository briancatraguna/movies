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
        val apiQuery = search.replace(" ","+")
        remoteDataSource.findMovies(apiQuery)
        return remoteDataSource.movies
    }

    fun getLoadingStatusMovies(): LiveData<Boolean>{
        return remoteDataSource.isLoadingMovies
    }

    fun getShows(search: String): LiveData<List<ShowsItem>>{
        val apiQuery = search.replace(" ","+")
        remoteDataSource.findShows(apiQuery)
        return remoteDataSource.shows
    }

    fun getLoadingStatusShows(): LiveData<Boolean>{
        return remoteDataSource.isLoadingShows
    }

    fun getMovieDetailsById(id: String): LiveData<SearchDetailMovieResponse>{
        remoteDataSource.getMovieDetailsbyId(id)
        return remoteDataSource.detailMovies
    }

    fun getShowDetailsById(id: String): LiveData<SearchDetailShowResponse>{
        remoteDataSource.getShowDetailsbyId(id)
        return remoteDataSource.detailShows
    }
}