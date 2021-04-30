package com.dicoding.movieapp.searchresult.detailshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movieapp.R
import com.dicoding.movieapp.data.source.remote.SearchDetailShowResponse
import com.dicoding.movieapp.databinding.ActivityDetailSearchShowBinding
import com.dicoding.movieapp.viewmodel.ViewModelFactory

class DetailSearchShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSearchShowBinding

    companion object {
        const val EXTRA_SHOW_ID = "extra_show_id"
        private const val IMG_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSearchShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.toolbarTitle.text = "TV Show Details"
        binding.progressBar.visibility = View.VISIBLE
        val id = intent.getStringExtra(EXTRA_SHOW_ID).toString()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this,factory)[DetailShowViewModel::class.java]
        viewModel.getShowById(id).observe(this,{show->
            populateView(show)
        })
    }

    private fun populateView(show: SearchDetailShowResponse) {
        binding.tvTitle.text = show.name
        binding.tvReleaseDate.text = show.firstAirDate
        binding.tvRating.text = show.voteAverage.toString()
        binding.tvOverview.text = show.overview
        Glide.with(this)
                .load(IMG_BASE_URL+show.posterPath)
                .apply(RequestOptions().override(500,500))
                .into(binding.imgPoster)
        binding.length.text = show.numberOfSeasons.toString()
        binding.popularity.text = show.popularity.toString()
        binding.episodes.text = show.numberOfEpisodes.toString()
        binding.progressBar.visibility = View.GONE
    }
}