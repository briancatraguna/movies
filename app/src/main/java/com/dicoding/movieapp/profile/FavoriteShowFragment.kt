package com.dicoding.movieapp.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movieapp.databinding.FragmentFavoriteShowBinding
import com.dicoding.movieapp.searchresult.detailshow.ShowStarredViewModel

class FavoriteShowFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFavoriteShowBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.rvShows
        recyclerView.layoutManager = LinearLayoutManager(context)
        val listShowAdapter = FavoriteShowAdapter()
        val viewModel = ShowStarredViewModel(requireActivity().application)
        viewModel.readAllShows.observe(requireActivity(),{shows->
            listShowAdapter.setData(shows)
            recyclerView.adapter = listShowAdapter
            if (shows.isEmpty()){
                binding.noFavorites.visibility = View.VISIBLE
            } else {
                binding.noFavorites.visibility = View.GONE
            }
        })
    }

}