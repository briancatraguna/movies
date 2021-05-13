package com.dicoding.movieapp.detail_movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movieapp.R
import com.dicoding.movieapp.data.source.local.ActorEntity

class CastAdapter internal constructor(private val context: Context):BaseAdapter() {
    internal var actors = arrayListOf<ActorEntity>()

    override fun getCount(): Int {
        return actors.size
    }

    override fun getItem(position: Int): Any {
        return actors[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_cast,parent,false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val actor = getItem(position) as ActorEntity
        viewHolder.bind(actor)
        return itemView
    }

    private inner class ViewHolder(view:View){
        private val txtName: TextView = view.findViewById(R.id.tv_actor)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_actor)

        fun bind(actor: ActorEntity){
            txtName.text = actor.actorName
            Glide.with(context)
                    .load(actor.actorPicture)
                    .apply(RequestOptions().override(400,400))
                    .into(imgPhoto)
        }
    }
}