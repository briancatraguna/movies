package com.dicoding.movieapp.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movieapp.R
import com.dicoding.movieapp.databinding.FragmentFavoriteMovieBinding
import com.dicoding.movieapp.searchresult.ListSearchMoviesAdapter
import com.dicoding.movieapp.searchresult.detailmovie.MovieStarredViewModel

class FavoriteMovieFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFavoriteMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.rvMovies
        recyclerView.layoutManager = LinearLayoutManager(context)
        val listMovieAdapter = FavoriteAdapter()
        val viewModel = MovieStarredViewModel(requireActivity().application)
        viewModel.readAllMovies.observe(requireActivity(),{movies->
            listMovieAdapter.setData(movies)
            recyclerView.adapter = listMovieAdapter
            if (movies.isEmpty()){
                binding.noFavorites.visibility = View.VISIBLE
            } else {
                binding.noFavorites.visibility = View.GONE
            }
        })
    }

}