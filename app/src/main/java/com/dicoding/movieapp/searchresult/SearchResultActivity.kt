package com.dicoding.movieapp.searchresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dicoding.movieapp.data.source.remote.*
import com.dicoding.movieapp.databinding.ActivitySearchResultBinding
import com.dicoding.movieapp.viewmodel.ViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchResultActivity : AppCompatActivity() {

    private lateinit var searchResultActivity: ActivitySearchResultBinding

    companion object {
        const val EXTRA_SEARCH = "extra_search"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchResultActivity = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(searchResultActivity.root)

        val query = intent.getStringExtra(EXTRA_SEARCH).toString()
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this,factory)[SearchResultViewModel::class.java]
        viewModel.getMovies(query).observe(this,{movies ->
            searchResultActivity.testIntent.text = movies[0].overview
        })

        searchResultActivity.toolbarSearchResults.backButton.setOnClickListener{
            finish()
        }
    }
}