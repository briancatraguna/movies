package com.dicoding.movieapp.searchresult

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.source.remote.MoviesItem
import com.dicoding.movieapp.data.source.remote.Repository

class SearchResultViewModel(private val repository: Repository): ViewModel() {

    fun getMovies(search: String): LiveData<List<MoviesItem>> {
        return repository.getMovies(search)
    }

    fun getStatus(): LiveData<Boolean>{
        return repository.getLoadingStatus()
    }

}