package com.dicoding.movieapp.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(){

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _movies = MutableLiveData<MoviesItem>()
    val movies: LiveData<MoviesItem> = _movies

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance():RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource().apply {
                    instance = this
                }
            }
    }

    fun getMovies(callback: (List<MoviesItem>) -> Unit) {
        val client = ApiConfig.getApiService().getMovies("john")
        client.enqueue(object : Callback<SearchMovieResponse> {
            override fun onResponse(
                    call: Call<SearchMovieResponse>,
                    response: Response<SearchMovieResponse>
            ) {
                var listMovies: ArrayList<MoviesItem> = ArrayList<MoviesItem>()
                if (response.isSuccessful) {
                    val rawList = response.body()?.results!!
                    for (item in rawList) {
                        listMovies.add(item)
                    }
                }
                callback(listMovies)
            }

            override fun onFailure(call: Call<SearchMovieResponse>, t: Throwable) {
                callback(emptyList()) // or throw error or use Result structure
            }

        })
    }
}