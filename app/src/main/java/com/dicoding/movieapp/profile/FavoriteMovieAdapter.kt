package com.dicoding.movieapp.profile

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movieapp.R
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import com.dicoding.movieapp.databinding.ItemSearchBinding
import com.dicoding.movieapp.searchresult.detailmovie.DetailSearchMovieActivity

class FavoriteMovieAdapter: RecyclerView.Adapter<FavoriteMovieAdapter.ListViewHolder>() {

    companion object {
        private const val IMG_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    private var listData: List<MoviesRoomEntity> = ArrayList<MoviesRoomEntity>()
    fun setData(list: List<MoviesRoomEntity>){
        this.listData = list
    }

    inner class ListViewHolder(private val binding: ItemSearchBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MoviesRoomEntity){
            with(binding){
                tvTitle.text = movie.title
                tvReleaseDate.text = movie.releaseDate
                tvRating.text = movie.rating.toString()
                if (movie.avatar == null){
                    imageContainer.setImageResource(R.drawable.ic_broken_image)
                } else {
                    Glide.with(itemView.context)
                        .load(IMG_BASE_URL+movie.avatar)
                        .apply(RequestOptions().override(400,400))
                        .into(imageContainer)
                }
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailSearchMovieActivity::class.java)
                    intent.putExtra(DetailSearchMovieActivity.EXTRA_MOVIE_ID,movie.movieId.toString())
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