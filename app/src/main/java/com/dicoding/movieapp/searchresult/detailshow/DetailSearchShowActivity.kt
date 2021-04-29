package com.dicoding.movieapp.searchresult.detailshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.movieapp.R

class DetailSearchShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SHOW_ID = "extra_show_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_search_show)
    }
}