package com.dicoding.movieapp.searchresult.detailshow

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movieapp.R
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
import com.dicoding.movieapp.data.source.remote.SearchDetailShowResponse
import com.dicoding.movieapp.databinding.ActivityDetailSearchShowBinding
import com.dicoding.movieapp.searchresult.detailmovie.MovieStarredViewModel
import com.dicoding.movieapp.viewmodel.ViewModelFactory

class DetailSearchShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSearchShowBinding
    private lateinit var showsObject: TvShowsRoomEntity
    private var statusFavorite = false

    companion object {
        const val EXTRA_SHOW_ID = "extra_show_id"
        private const val IMG_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSearchShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.toolbarTitle.text = getString(R.string.tv_show_details)
        binding.progressBar.visibility = View.VISIBLE
        val id = intent.getStringExtra(EXTRA_SHOW_ID).toString()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this,factory)[DetailShowViewModel::class.java]
        viewModel.getShowById(id).observe(this,{show->
            populateView(show)
            showsObject = TvShowsRoomEntity(
                    showId = show.id,
                    title = show.name,
                    avatar = show.backdropPath,
                    releaseDate = show.firstAirDate,
                    rating = show.voteAverage
            )
        })
        setStatus(id.toInt())
        val dbViewModel = ShowStarredViewModel(application)
        binding.toolbar.imgStar.setOnClickListener {
            statusFavorite = !statusFavorite
            setStatusStarred(statusFavorite)
            if (statusFavorite){
                dbViewModel.addShow(showsObject)
                Toast.makeText(this,"Show added!",Toast.LENGTH_SHORT).show()
            } else {
                dbViewModel.delShowById(id.toInt())
                Toast.makeText(this,"Deleted show!",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setStatus(showId: Int) {
        val dbViewModel = ShowStarredViewModel(application)
        dbViewModel.readAllShows.observe(this,{shows->
            for (show in shows){
                val currentId = show.showId
                if (currentId == showId){
                    statusFavorite = true
                    setStatusStarred(statusFavorite)
                }
            }
        })
        setStatusStarred(statusFavorite)
    }

    private fun setStatusStarred(starred: Boolean) {
        if (starred){
            binding.toolbar.imgStar.setImageResource(R.drawable.ic_star)
        } else {
            binding.toolbar.imgStar.setImageResource(R.drawable.ic_star_border)
        }
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
        binding.imgPoster.setOnClickListener{
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(show.homepage))
                startActivity(intent)
            } catch (e: Exception){
                Toast.makeText(this,"No Homepage Found!",Toast.LENGTH_SHORT).show()
            }
        }
        if (show.posterPath == "null"){
            binding.imgPoster.setImageResource(R.drawable.ic_broken_image)
        }
        binding.length.text = show.numberOfSeasons.toString()
        binding.popularity.text = show.popularity.toString()
        binding.episodes.text = show.numberOfEpisodes.toString()
        binding.progressBar.visibility = View.GONE
    }
}