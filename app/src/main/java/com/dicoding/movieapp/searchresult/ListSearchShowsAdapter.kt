package com.dicoding.movieapp.searchresult

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movieapp.R
import com.dicoding.movieapp.data.source.remote.ShowsItem
import com.dicoding.movieapp.databinding.ItemSearchBinding
import com.dicoding.movieapp.searchresult.detailshow.DetailSearchShowActivity

class ListSearchShowsAdapter: RecyclerView.Adapter<ListSearchShowsAdapter.ListViewHolder>() {

    companion object {
        private const val IMG_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    private var listData: List<ShowsItem> = ArrayList<ShowsItem>()
    fun setData(list: List<ShowsItem>){
        this.listData = list
    }

    inner class ListViewHolder(private val binding: ItemSearchBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(show: ShowsItem){
            with(binding){
                tvTitle.text = show.name
                tvRating.text = show.voteAverage.toString()
                tvReleaseDate.text = show.firstAirDate
                if (show.backdropPath == null){
                    imageContainer.setImageResource(R.drawable.ic_broken_image)
                } else {
                    Glide.with(itemView.context)
                        .load(IMG_BASE_URL+show.backdropPath)
                        .apply(RequestOptions().override(400,400))
                        .into(imageContainer)
                }
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context,DetailSearchShowActivity::class.java)
                    intent.putExtra(DetailSearchShowActivity.EXTRA_SHOW_ID,show.id)
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