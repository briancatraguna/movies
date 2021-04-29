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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        searchMoviesFragmentBinding = FragmentSearchMoviesBinding.inflate(layoutInflater,container,false)
        return searchMoviesFragmentBinding.root
    }

}