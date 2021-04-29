package com.dicoding.movieapp.searchresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dicoding.movieapp.databinding.FragmentSearchTvShowBinding
import com.dicoding.movieapp.viewmodel.ViewModelFactory

class SearchTvShowFragment : Fragment() {

    private lateinit var searchTvShowFragmentBinding: FragmentSearchTvShowBinding
    private var query: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        query = arguments?.getString(SearchResultActivity.EXTRA_SEARCH)
        searchTvShowFragmentBinding = FragmentSearchTvShowBinding.inflate(layoutInflater,container,false)
        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(requireActivity(),factory)[SearchResultViewModel::class.java]
        viewModel.getShows(query!!).observe(this,{shows ->
            val showList = shows
        })
        viewModel.getStatusMovies().observe(this,{status ->
            if (status){
                searchTvShowFragmentBinding.progressBar.visibility = View.VISIBLE
            } else {
                searchTvShowFragmentBinding.progressBar.visibility = View.GONE
            }
        })
        return searchTvShowFragmentBinding.root
    }

}