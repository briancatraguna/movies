package com.dicoding.movieapp.searchresult.detailmovie

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movieapp.R
import com.dicoding.movieapp.data.source.remote.SearchDetailMovieResponse
import com.dicoding.movieapp.databinding.ActivityDetailSearchMovieBinding
import com.dicoding.movieapp.searchresult.SearchResultViewModel
import com.dicoding.movieapp.viewmodel.ViewModelFactory

class DetailSearchMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSearchMovieBinding

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
        private const val IMG_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSearchMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.toolbarTitle.text = "Movie Details"
        binding.progressBar.visibility = View.VISIBLE
        val id = intent.getStringExtra(EXTRA_MOVIE_ID).toString()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this,factory)[DetailMovieViewModel::class.java]
        viewModel.getMovieById(id).observe(this,{movie->
            populateView(movie)
        })
    }

    private fun populateView(movie: SearchDetailMovieResponse) {
        binding.tvTitle.text = movie.title
        binding.tvReleaseDate.text = movie.releaseDate
        binding.tvRating.text = movie.voteAverage.toString()
        binding.tvOverview.text = movie.overview
        Glide.with(this)
                .load(IMG_BASE_URL+movie.posterPath)
                .apply(RequestOptions().override(500,500))
                .into(binding.imgPoster)
        binding.length.text = "${movie.runtime} m"
        binding.popularity.text = movie.popularity.toString()
        if (movie.adult == true){
            binding.imgSafe.setImageResource(R.drawable.ic_not_safe)
        } else{
            binding.imgSafe.setImageResource(R.drawable.ic_safe_for_kids)
        }
        binding.imgPoster.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.homepage))
            startActivity(intent)
        }
        binding.progressBar.visibility = View.GONE
    }
}