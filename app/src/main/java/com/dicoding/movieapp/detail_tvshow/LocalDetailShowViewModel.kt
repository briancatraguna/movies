package com.dicoding.movieapp.detail_tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.data.source.local.TVShowDetailEntity
import com.dicoding.movieapp.data.source.local.TVShowEntity
import com.dicoding.movieapp.data.source.Repository

class LocalDetailShowViewModel(private val repository: Repository):ViewModel() {

    private fun getShowBasicDetails(): LiveData<List<TVShowEntity>> {
        return repository.getLocalShows()
    }
    fun getBasicShowDetailsById(showId: String): TVShowEntity?{
        return getShowBasicDetails().value?.firstOrNull(){
            it.showId == showId
        }
    }

    private fun getShowDetails(): LiveData<List<TVShowDetailEntity>>{
        return repository.getLocalDetailShows()
    }
    fun getDetailsById(showId: String): TVShowDetailEntity?{
        return getShowDetails().value?.firstOrNull{
            it.showId == showId
        }
    }
}