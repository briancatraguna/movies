package com.dicoding.movieapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.movieapp.data.source.remote.Repository
import com.dicoding.movieapp.injection.Injection
import com.dicoding.movieapp.searchresult.SearchMoviesFragment
import com.dicoding.movieapp.searchresult.SearchResultViewModel
import com.dicoding.movieapp.searchresult.SearchTvShowFragment
import com.dicoding.movieapp.searchresult.detailmovie.DetailMovieViewModel
import com.dicoding.movieapp.searchresult.detailshow.DetailShowViewModel

class ViewModelFactory private constructor(private val repository: Repository): ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this){
                    instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                        instance = this
                    }
                }
    }

    @Suppress
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(SearchResultViewModel::class.java) -> {
                return SearchResultViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailShowViewModel::class.java) -> {
                return DetailShowViewModel(repository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: "+modelClass.name)
        }
    }

}