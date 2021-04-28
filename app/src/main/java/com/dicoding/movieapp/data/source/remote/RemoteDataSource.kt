package com.dicoding.movieapp.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(){

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _movies = MutableLiveData<List<MoviesItem>>()
    val movies: LiveData<List<MoviesItem>> = _movies

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
        _isLoading.value = true
        val client = ApiConfig.getApiService().getMovies(search)
        client.enqueue(object: Callback<SearchMovieResponse>{
            override fun onResponse(call: Call<SearchMovieResponse>, response: Response<SearchMovieResponse>) {
                if (response.isSuccessful){
                    val result = response.body()?.results
                    _movies.value = result
                    _isLoading.value = false
                } else {
                    Log.e(TAG,"onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<SearchMovieResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG,"onFailure: ${t.message.toString()}")
            }

        })
    }
}