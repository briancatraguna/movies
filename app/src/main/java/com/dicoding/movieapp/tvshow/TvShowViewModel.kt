package com.dicoding.movieapp.tvshow

import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.TVShowEntity
import com.dicoding.movieapp.utils.DataDummy

class TvShowViewModel:ViewModel() {

    fun getTvShows():ArrayList<TVShowEntity>{
        return DataDummy.generateTvShows()
    }
}