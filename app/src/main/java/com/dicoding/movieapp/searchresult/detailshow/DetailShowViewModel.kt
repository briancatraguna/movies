package com.dicoding.movieapp.searchresult.detailshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.source.remote.Repository
import com.dicoding.movieapp.data.source.remote.SearchDetailShowResponse

class DetailShowViewModel(private val repository: Repository): ViewModel() {

    fun getShowById(id: String): LiveData<SearchDetailShowResponse> {
        return repository.getShowDetailsById(id)
    }

}