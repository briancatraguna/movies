package com.dicoding.movieapp.searchresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.movieapp.R
import com.dicoding.movieapp.databinding.FragmentSearchMoviesBinding

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
        searchMoviesFragmentBinding.tvMoviesFragment.text = query
        return searchMoviesFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}