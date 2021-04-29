package com.dicoding.movieapp.searchresult

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movieapp.R
import com.dicoding.movieapp.data.source.remote.MoviesItem
import com.dicoding.movieapp.databinding.ItemSearchBinding
import com.dicoding.movieapp.searchresult.detailmovie.DetailSearchMovieActivity

class ListSearchMoviesAdapter: RecyclerView.Adapter<ListSearchMoviesAdapter.ListViewHolder>() {

    companion object {
        private const val IMG_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    private var listData: List<MoviesItem> = ArrayList<MoviesItem>()
    fun setData(list: List<MoviesItem>){
        this.listData = list
    }

    inner class ListViewHolder(private val binding: ItemSearchBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MoviesItem){
            with(binding){
                tvTitle.text = movie.title
                tvReleaseDate.text = movie.releaseDate
                tvRating.text = movie.voteAverage.toString()
                if (movie.backdropPath == null){
                    imageContainer.setImageResource(R.drawable.ic_broken_image)
                } else {
                    Glide.with(itemView.context)
                        .load(IMG_BASE_URL+movie.backdropPath)
                        .apply(RequestOptions().override(400,400))
                        .into(imageContainer)
                }
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailSearchMovieActivity::class.java)
                    intent.putExtra(DetailSearchMovieActivity.EXTRA_MOVIE_ID,movie.id)
                    itemView.context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}