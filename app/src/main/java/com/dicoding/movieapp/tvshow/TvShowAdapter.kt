package com.dicoding.movieapp.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movieapp.data.source.local.TVShowEntity
import com.dicoding.movieapp.databinding.ItemTvShowsBinding
import com.dicoding.movieapp.detail_tvshow.DetailShowActivity

class TvShowAdapter:RecyclerView.Adapter<TvShowAdapter.ShowViewHolder>() {

    private var tvShows = ArrayList<TVShowEntity>()

    fun setShows(shows: List<TVShowEntity>?){
        if (shows == null) return
        this.tvShows.clear()
        this.tvShows.addAll(shows)
    }

    inner class ShowViewHolder(private val binding: ItemTvShowsBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TVShowEntity){
            with(binding){
                tvTitle.text = tvShow.title
                tvSeasons.text = tvShow.seasons
                tvEpisodes.text = tvShow.episodes
                tvRating.text = tvShow.rating
                Glide.with(itemView.context)
                    .load(tvShow.imagePath)
                    .apply(RequestOptions().override(400,400))
                    .into(imageContainer)
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context,DetailShowActivity::class.java)
                    intent.putExtra(DetailShowActivity.EXTRA_SHOW,tvShow.showId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val itemsShowBinding = ItemTvShowsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ShowViewHolder(itemsShowBinding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val tvShow = tvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }
}