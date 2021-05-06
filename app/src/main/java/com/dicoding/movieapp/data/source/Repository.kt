package com.dicoding.movieapp.data.source

import androidx.lifecycle.LiveData
import com.dicoding.movieapp.data.source.local.MovieDetailEntity
import com.dicoding.movieapp.data.source.local.MovieEntity
import com.dicoding.movieapp.data.source.local.TVShowDetailEntity
import com.dicoding.movieapp.data.source.local.TVShowEntity
import com.dicoding.movieapp.data.source.local.LocalDataSource
import com.dicoding.movieapp.data.source.remote.*


class Repository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource){

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteData: RemoteDataSource,localData: LocalDataSource) =
                instance ?: synchronized(this){
                    instance ?: Repository(remoteData,localData).apply { instance = this }
                }
    }

    fun getRemoteMovies(search: String): LiveData<List<MoviesItem>> {
        val apiQuery = search.replace(" ","+")
        remoteDataSource.findMovies(apiQuery)
        return remoteDataSource.movies
    }

    fun getRemoteLoadingStatusMovies(): LiveData<Boolean>{
        return remoteDataSource.isLoadingMovies
    }

    fun getRemoteShows(search: String): LiveData<List<ShowsItem>>{
        val apiQuery = search.replace(" ","+")
        remoteDataSource.findShows(apiQuery)
        return remoteDataSource.shows
    }

    fun getRemoteLoadingStatusShows(): LiveData<Boolean>{
        return remoteDataSource.isLoadingShows
    }

    fun getRemoteMovieDetailsById(id: String): LiveData<SearchDetailMovieResponse>{
        remoteDataSource.getMovieDetailsbyId(id)
        return remoteDataSource.detailMovies
    }

    fun getRemoteShowDetailsById(id: String): LiveData<SearchDetailShowResponse>{
        remoteDataSource.getShowDetailsbyId(id)
        return remoteDataSource.detailShows
    }

    fun getLocalMovies(): LiveData<List<MovieEntity>>{
        localDataSource.getMovies()
        return localDataSource.movies
    }

    fun getLocalShows(): LiveData<List<TVShowEntity>>{
        localDataSource.getShows()
        return localDataSource.shows
    }

    fun getLocalDetailMovies(): LiveData<List<MovieDetailEntity>>{
        localDataSource.getDetailMovies()
        return localDataSource.detailMovies
    }

    fun getLocalDetailShows(): LiveData<List<TVShowDetailEntity>>{
        localDataSource.getDetailShows()
        return localDataSource.detailShows
    }
}