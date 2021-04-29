package com.dicoding.movieapp.searchresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.movieapp.R
import com.dicoding.movieapp.databinding.FragmentSearchTvShowBinding

class SearchTvShowFragment : Fragment() {

    private lateinit var searchTvShowFragmentBinding: FragmentSearchTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        searchTvShowFragmentBinding = FragmentSearchTvShowBinding.inflate(layoutInflater,container,false)
        return searchTvShowFragmentBinding.root
    }

}