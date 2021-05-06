package com.dicoding.movieapp.searchresult.detailmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.source.Repository
import com.dicoding.movieapp.data.source.remote.SearchDetailMovieResponse

class DetailMovieViewModel(private val repository: Repository): ViewModel() {

    fun getMovieById(id: String): LiveData<SearchDetailMovieResponse> {
        return repository.getRemoteMovieDetailsById(id)
    }

}