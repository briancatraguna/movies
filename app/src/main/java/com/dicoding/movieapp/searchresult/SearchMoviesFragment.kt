package com.dicoding.movieapp.searchresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dicoding.movieapp.databinding.FragmentSearchMoviesBinding
import com.dicoding.movieapp.viewmodel.ViewModelFactory

class SearchMoviesFragment : Fragment() {

    private lateinit var searchMoviesFragmentBinding: FragmentSearchMoviesBinding
    private var query: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        query = arguments?.getString(SearchResultActivity.EXTRA_SEARCH)
        searchMoviesFragmentBinding = FragmentSearchMoviesBinding.inflate(layoutInflater,container,false)
        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(requireActivity(),factory)[SearchResultViewModel::class.java]
        viewModel.getMovies(query!!).observe(this,{movies ->
            searchMoviesFragmentBinding.tvMoviesFragment.text = movies[0].overview
        })
        viewModel.getStatusMovies().observe(this,{status ->
            if (status){
                searchMoviesFragmentBinding.progressBar.visibility = View.VISIBLE
            } else {
                searchMoviesFragmentBinding.progressBar.visibility = View.GONE
            }
        })
        return searchMoviesFragmentBinding.root
    }

}