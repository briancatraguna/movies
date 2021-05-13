package com.dicoding.movieapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.DetailDataDummy

class LocalDataSource {

    private val _movies = MutableLiveData<List<MovieEntity>>()
    val movies: LiveData<List<MovieEntity>> = _movies

    private val _shows = MutableLiveData<List<TVShowEntity>>()
    val shows: LiveData<List<TVShowEntity>> = _shows

    private val _detailMovies = MutableLiveData<List<MovieDetailEntity>>()
    val detailMovies: LiveData<List<MovieDetailEntity>> = _detailMovies

    private val _detailShows = MutableLiveData<List<TVShowDetailEntity>>()
    val detailShows: LiveData<List<TVShowDetailEntity>> = _detailShows

    companion object {
        private const val TAG = "LocalDataSource"

        @Volatile
        private var instance: LocalDataSource? = null

        fun getInstance():LocalDataSource =
                instance ?: synchronized(this){
                    instance?: LocalDataSource().apply {
                        instance = this
                    }
                }
    }

    fun getMovies(){
        val dataDummyMovies = DataDummy.generateMovies()
        _movies.value = dataDummyMovies
    }

    fun getShows(){
        val dataDummyShows = DataDummy.generateTvShows()
        _shows.value = dataDummyShows
    }

    fun getDetailMovies(){
        val dummyDetailMovies = DetailDataDummy.getMovieDetail()
        _detailMovies.value = dummyDetailMovies
    }

    fun getDetailShows(){
        val dummyDetailShows = DetailDataDummy.getShowDetail()
        _detailShows.value = dummyDetailShows
    }

}