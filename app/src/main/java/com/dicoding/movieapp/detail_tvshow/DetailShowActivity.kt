package com.dicoding.movieapp.detail_tvshow

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movieapp.R
import com.dicoding.movieapp.data.source.local.ActorEntity
import com.dicoding.movieapp.data.source.local.TVShowDetailEntity
import com.dicoding.movieapp.data.source.local.TVShowEntity
import com.dicoding.movieapp.databinding.ActivityDetailShowBinding
import com.dicoding.movieapp.detail_movie.CastAdapter
import com.dicoding.movieapp.viewmodel.ViewModelFactory

class DetailShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailShowBinding
    private lateinit var starIcon: ImageView

    companion object {
        const val EXTRA_SHOW = "extra_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailShowBinding.inflate(layoutInflater)
        starIcon = binding.toolbarDetail.star
        setContentView(binding.root)

        //Toolbar
        binding.toolbarDetail.backButton.setOnClickListener{
            finish()
        }
        var starStatus = false
        setStarStatus(starStatus)
        starIcon.setOnClickListener{
            starStatus = !starStatus
            setStarStatus(starStatus)
            if (starStatus){
                Toast.makeText(this,"Starred!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Unstarred!", Toast.LENGTH_SHORT).show()
            }
        }

        //Getting details
        val showId = intent.getStringExtra(EXTRA_SHOW).toString()
        val details1 = getShowBasicDetails(showId)
        val details2 = getShowDetails(showId)

        //Binding to views
        Glide.with(this.applicationContext)
                .load(details1?.imagePath)
                .apply(RequestOptions().override(400,400))
                .into(binding.showAvatar)
        binding.tvShowTitle.text = details1?.title
        binding.author.text = "By ${details2?.director}"
        Glide.with(this.applicationContext)
                .load(details2?.trailerThumbnail)
                .apply(RequestOptions().override(320,180))
                .into(binding.imgTrailer)
        binding.starsDetail.text = details1?.rating
        binding.tvOverview.text = details2?.overview
        val castList: ArrayList<ActorEntity> = details2?.cast!!
        val listView: ListView = binding.lvCast
        val adapter = CastAdapter(this)
        adapter.actors = castList
        listView.adapter = adapter
        binding.playButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(details2?.trailerLink))
            startActivity(intent)
        }
    }

    private fun getShowBasicDetails(showId: String): TVShowEntity? {
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this,factory)[LocalDetailShowViewModel::class.java]
        return viewModel.getBasicShowDetailsById(showId)
    }

    private fun getShowDetails(showId: String): TVShowDetailEntity? {
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this,factory)[LocalDetailShowViewModel::class.java]
        return viewModel.getDetailsById(showId)
    }

    private fun setStarStatus(starStatus: Boolean) {
        if (starStatus){
            starIcon.setImageResource(R.drawable.ic_star)
        } else {
            starIcon.setImageResource(R.drawable.ic_star_border)
        }
    }
}