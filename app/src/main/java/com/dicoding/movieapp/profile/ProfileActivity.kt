package com.dicoding.movieapp.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.movieapp.R
import com.dicoding.movieapp.databinding.ActivityProfileBinding

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
    }
}