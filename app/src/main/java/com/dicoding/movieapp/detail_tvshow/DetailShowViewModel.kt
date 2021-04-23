package com.dicoding.movieapp.detail_tvshow

import com.dicoding.movieapp.data.TVShowDetailEntity
import com.dicoding.movieapp.data.TVShowEntity
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.DetailDataDummy

class DetailShowViewModel {

    private fun getShowBasicDetails():ArrayList<TVShowEntity>{
        return DataDummy.generateTvShows()
    }
    fun getBasicShowDetailsById(showId: String): TVShowEntity?{
        return getShowBasicDetails().firstOrNull{
            it.showId == showId
        }
    }

    private fun getShowDetails():ArrayList<TVShowDetailEntity>{
        return DetailDataDummy.getShowDetail()
    }
    fun getDetailsById(showId: String): TVShowDetailEntity?{
        return getShowDetails().firstOrNull{
            it.showId == showId
        }
    }
}