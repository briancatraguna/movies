package com.dicoding.movieapp.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dicoding.movieapp.R
import com.dicoding.movieapp.databinding.ActivityHomeBinding
import com.dicoding.movieapp.profile.ProfileActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val profPic = activityHomeBinding.toolbarHome.profilePicture
        profPic.setOnClickListener{
            val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        val sectionsPagerAdapter = SectionsPagerAdapter(this,supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionsPagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)

    }
}