package com.dicoding.movieapp.searchresult.detailshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dicoding.movieapp.R
import com.dicoding.movieapp.databinding.ActivityDetailSearchShowBinding
import com.dicoding.movieapp.viewmodel.ViewModelFactory

class DetailSearchShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSearchShowBinding

    companion object {
        const val EXTRA_SHOW_ID = "extra_show_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSearchShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getStringExtra(EXTRA_SHOW_ID).toString()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this,factory)[DetailShowViewModel::class.java]
        binding.tvTitle.text = id
    }
}