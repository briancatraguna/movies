package com.dicoding.movieapp.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.movieapp.R
import com.dicoding.movieapp.databinding.ActivityProfileBinding
import com.dicoding.movieapp.home.SectionsPagerAdapter

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val backButton = binding.toolbarProfile.backButton
        setContentView(binding.root)

        backButton.setOnClickListener{
            finish()
        }

        val sectionsPagerAdapter = SectionsPagerAdapter(this,supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabFav.setupWithViewPager(binding.viewPager)
    }
}