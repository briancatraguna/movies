package com.dicoding.movieapp.searchresult.detailmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.dicoding.movieapp.R
import com.dicoding.movieapp.databinding.ActivityDetailSearchMovieBinding
import com.dicoding.movieapp.viewmodel.ViewModelFactory

class DetailSearchMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSearchMovieBinding

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSearchMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getStringExtra(EXTRA_MOVIE_ID).toString()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this,factory)[DetailMovieViewModel::class.java]
        binding.tvTitle.text = id
    }
}