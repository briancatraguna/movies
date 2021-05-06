package com.dicoding.movieapp.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.source.local.TVShowEntity
import com.dicoding.movieapp.data.source.Repository

class TvShowViewModel(private val repository: Repository):ViewModel() {

    fun getTvShows(): LiveData<List<TVShowEntity>> {
        return repository.getLocalShows()
    }
}