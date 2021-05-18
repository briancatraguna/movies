package com.dicoding.movieapp.searchresult.detailmovie

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
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import com.dicoding.movieapp.data.source.remote.SearchDetailMovieResponse
import com.dicoding.movieapp.databinding.ActivityDetailSearchMovieBinding
import com.dicoding.movieapp.viewmodel.ViewModelFactory
import java.lang.Exception

class DetailSearchMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSearchMovieBinding
    private lateinit var moviesObject: MoviesRoomEntity
    private var statusFavorite = false

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
        private const val IMG_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSearchMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.toolbarTitle.text = getString(R.string.movie_details)
        binding.progressBar.visibility = View.VISIBLE
        val id = intent.getStringExtra(EXTRA_MOVIE_ID).toString()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this,factory)[DetailMovieViewModel::class.java]
        viewModel.getMovieById(id).observe(this,{movie->
            populateView(movie)
            moviesObject = MoviesRoomEntity(
                    movieId = movie.id,
                    title = movie.title,
                    avatar = movie.backdropPath,
                    releaseDate = movie.releaseDate,
                    rating = movie.voteAverage
            )
        })
        setStatus(id.toInt())
        val dbViewModel = MovieStarredViewModel(application)
        binding.toolbar.imgStar.setOnClickListener {
            statusFavorite = !statusFavorite
            setStatusStarred(statusFavorite)
            if (statusFavorite){
                dbViewModel.addMovie(moviesObject)
                Toast.makeText(this,"Added movie!",Toast.LENGTH_SHORT).show()
            } else {
                dbViewModel.delMovieById(id.toInt())
                Toast.makeText(this,"Deleted movie!",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setStatus(movieId: Int) {
        val dbViewModel = MovieStarredViewModel(application)
        dbViewModel.readAllMovies.observe(this,{movies->
            for (movie in movies){
                val currentId = movie.movieId
                if (currentId == movieId){
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

    private fun populateView(movie: SearchDetailMovieResponse) {
        binding.tvTitle.text = movie.title
        binding.tvReleaseDate.text = movie.releaseDate
        binding.tvRating.text = movie.voteAverage.toString()
        binding.tvOverview.text = movie.overview
        Glide.with(this)
                .load(IMG_BASE_URL+movie.posterPath)
                .apply(RequestOptions().override(500,500))
                .into(binding.imgPoster)
        if (movie.posterPath == null){
            binding.imgPoster.setImageResource(R.drawable.ic_broken_image)
        }
        binding.length.text = "${movie.runtime} m"
        binding.popularity.text = movie.popularity.toString()
        if (movie.adult == true){
            binding.imgSafe.setImageResource(R.drawable.ic_not_safe)
        } else{
            binding.imgSafe.setImageResource(R.drawable.ic_safe_for_kids)
        }
        binding.imgPoster.setOnClickListener{
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.homepage))
                startActivity(intent)
            } catch (e: Exception){
                Toast.makeText(this,"No Homepage Found!",Toast.LENGTH_SHORT).show()
            }
        }
        binding.progressBar.visibility = View.GONE
    }
}