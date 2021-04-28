package com.dicoding.movieapp.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(){

    private val _isLoadingMovies = MutableLiveData<Boolean>()
    val isLoadingMovies: LiveData<Boolean> = _isLoadingMovies

    private val _movies = MutableLiveData<List<MoviesItem>>()
    val movies: LiveData<List<MoviesItem>> = _movies

    private val _isLoadingShows = MutableLiveData<Boolean>()
    val isLoadingShows: LiveData<Boolean> = _isLoadingShows

    private val _shows = MutableLiveData<List<ShowsItem>>()
    val shows: LiveData<List<ShowsItem>> = _shows

    companion object {
        private const val TAG = "RemoteDataSource"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance():RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource().apply {
                    instance = this
                }
            }
    }

    fun findMovies(search: String){
        _isLoadingMovies.value = true
        val client = ApiConfig.getApiService().getMovies(search)
        client.enqueue(object: Callback<SearchMovieResponse>{
            override fun onResponse(call: Call<SearchMovieResponse>, response: Response<SearchMovieResponse>) {
                if (response.isSuccessful){
                    val result = response.body()?.results
                    _movies.value = result
                    _isLoadingMovies.value = false
                } else {
                    Log.e(TAG,"onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<SearchMovieResponse>, t: Throwable) {
                _isLoadingMovies.value = false
                Log.e(TAG,"onFailure: ${t.message.toString()}")
            }

        })
    }

    fun findShows(search: String){
        _isLoadingShows.value = true
        val client = ApiConfig.getApiService().getShows(search)
        client.enqueue(object: Callback<SearchShowResponse>{
            override fun onResponse(call: Call<SearchShowResponse>, response: Response<SearchShowResponse>) {
                if (response.isSuccessful){
                    val result = response.body()?.results
                    _shows.value = result
                    _isLoadingShows.value = false
                } else {
                    Log.e(TAG,"onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<SearchShowResponse>, t: Throwable) {
                _isLoadingShows.value = false
                Log.e(TAG,"onFailure: ${t.message.toString()}")
            }

        })
    }
}