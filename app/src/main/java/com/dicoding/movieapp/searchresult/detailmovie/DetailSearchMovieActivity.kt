package com.dicoding.movieapp.searchresult.detailmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.movieapp.R

class DetailSearchMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_search_movie)
    }
}