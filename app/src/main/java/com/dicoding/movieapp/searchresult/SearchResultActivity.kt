package com.dicoding.movieapp.searchresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.dicoding.movieapp.databinding.ActivitySearchResultBinding
import com.dicoding.movieapp.home.SectionsPagerAdapter
import com.dicoding.movieapp.viewmodel.ViewModelFactory

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

        val sectionsPagerAdapter = SearchSectionsPagerAdapter(this,supportFragmentManager)
        searchResultActivity.viewPager.adapter = sectionsPagerAdapter
        searchResultActivity.tabs.setupWithViewPager(searchResultActivity.viewPager)

        searchResultActivity.tvShowingResults.text = "Showing results for \"${query}\""

        searchResultActivity.toolbarSearchResults.backButton.setOnClickListener{
            finish()
        }
    }
}