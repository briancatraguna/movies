package com.dicoding.movieapp.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.movieapp.utils.EspressoIdlingResources
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

    private val _detailMovies = MutableLiveData<SearchDetailMovieResponse>()
    val detailMovies: LiveData<SearchDetailMovieResponse> = _detailMovies

    private val _detailShows = MutableLiveData<SearchDetailShowResponse>()
    val detailShows: LiveData<SearchDetailShowResponse> = _detailShows

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
        EspressoIdlingResources.increment()
        _isLoadingMovies.value = true
        val client = ApiConfig.getApiService().getMovies(search)
        client.enqueue(object: Callback<SearchMovieResponse>{
            override fun onResponse(call: Call<SearchMovieResponse>, response: Response<SearchMovieResponse>) {
                if (response.isSuccessful){
                    val result = response.body()?.results
                    _movies.value = result
                    _isLoadingMovies.value = false
                    EspressoIdlingResources.decrement()
                } else {
                    Log.e(TAG,"onFailure: ${response.message()}")
                    EspressoIdlingResources.decrement()
                }
            }

            override fun onFailure(call: Call<SearchMovieResponse>, t: Throwable) {
                _isLoadingMovies.value = false
                Log.e(TAG,"onFailure: ${t.message.toString()}")
                EspressoIdlingResources.decrement()
            }

        })
    }

    fun findShows(search: String){
        EspressoIdlingResources.increment()
        _isLoadingShows.value = true
        val client = ApiConfig.getApiService().getShows(search)
        client.enqueue(object: Callback<SearchShowResponse>{
            override fun onResponse(call: Call<SearchShowResponse>, response: Response<SearchShowResponse>) {
                if (response.isSuccessful){
                    val result = response.body()?.results
                    _shows.value = result
                    _isLoadingShows.value = false
                    EspressoIdlingResources.decrement()
                } else {
                    Log.e(TAG,"onFailure: ${response.message()}")
                    EspressoIdlingResources.decrement()
                }
            }

            override fun onFailure(call: Call<SearchShowResponse>, t: Throwable) {
                _isLoadingShows.value = false
                Log.e(TAG,"onFailure: ${t.message.toString()}")
                EspressoIdlingResources.decrement()
            }

        })
    }

    fun getMovieDetailsbyId(id: String){
        EspressoIdlingResources.increment()
        _isLoadingMovies.value = true
        val client = ApiConfig.getApiService().getMovieById(id)
        client.enqueue(object : Callback<SearchDetailMovieResponse> {
            override fun onResponse(call: Call<SearchDetailMovieResponse>, response: Response<SearchDetailMovieResponse>) {
                if (response.isSuccessful){
                    val result = response.body()
                    _detailMovies.value = result
                    _isLoadingMovies.value = false
                    EspressoIdlingResources.decrement()
                } else {
                    Log.e(TAG,"onFailure: ${response.message()}")
                    EspressoIdlingResources.decrement()
                }
            }

            override fun onFailure(call: Call<SearchDetailMovieResponse>, t: Throwable) {
                _isLoadingMovies.value = false
                Log.e(TAG,"onFailure: ${t.message.toString()}")
                EspressoIdlingResources.decrement()
            }
        })
    }

    fun getShowDetailsbyId(id: String){
        EspressoIdlingResources.increment()
        _isLoadingShows.value = true
        val client = ApiConfig.getApiService().getShowById(id)
        client.enqueue(object : Callback<SearchDetailShowResponse>{
            override fun onResponse(call: Call<SearchDetailShowResponse>, response: Response<SearchDetailShowResponse>) {
                if (response.isSuccessful){
                    val result = response.body()
                    _detailShows.value = result
                    _isLoadingShows.value = false
                    EspressoIdlingResources.decrement()
                } else {
                    Log.e(TAG,"onFailure: ${response.message()}")
                    EspressoIdlingResources.decrement()
                }
            }

            override fun onFailure(call: Call<SearchDetailShowResponse>, t: Throwable) {
                _isLoadingShows.value = false
                Log.e(TAG,"onFailure: ${t.message.toString()}")
                EspressoIdlingResources.decrement()
            }

        })
    }
}