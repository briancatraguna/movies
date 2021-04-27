package com.dicoding.movieapp.searchresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.movieapp.databinding.ActivitySearchResultBinding

class SearchResultActivity : AppCompatActivity() {

    private lateinit var searchResultActivity: ActivitySearchResultBinding

    companion object {
        const val EXTRA_SEARCH = "extra_search"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchResultActivity = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(searchResultActivity.root)

        searchResultActivity.testIntent.text = intent.getStringExtra(EXTRA_SEARCH)
    }
}