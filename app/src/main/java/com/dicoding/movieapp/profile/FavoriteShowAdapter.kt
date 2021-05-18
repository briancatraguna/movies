package com.dicoding.movieapp.profile

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movieapp.R
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
import com.dicoding.movieapp.databinding.ItemSearchBinding
import com.dicoding.movieapp.searchresult.detailshow.DetailSearchShowActivity

class FavoriteShowAdapter: RecyclerView.Adapter<FavoriteShowAdapter.ListViewHolder>() {

    companion object {
        private const val IMG_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    private var listData: List<TvShowsRoomEntity> = ArrayList<TvShowsRoomEntity>()
    fun setData(list: List<TvShowsRoomEntity>){
        this.listData = list
    }

    inner class ListViewHolder(private val binding: ItemSearchBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(show: TvShowsRoomEntity){
            with(binding){
                tvTitle.text = show.title
                tvReleaseDate.text = show.releaseDate
                tvRating.text = show.rating.toString()
                if (show.avatar == null){
                    imageContainer.setImageResource(R.drawable.ic_broken_image)
                } else {
                    Glide.with(itemView.context)
                            .load(IMG_BASE_URL+show.avatar)
                            .apply(RequestOptions().override(400,400))
                            .into(imageContainer)
                }
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailSearchShowActivity::class.java)
                    intent.putExtra(DetailSearchShowActivity.EXTRA_SHOW_ID,show.showId.toString())
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