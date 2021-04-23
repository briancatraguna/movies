package com.dicoding.movieapp.splashscreen

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dicoding.movieapp.R
import com.dicoding.movieapp.databinding.ActivitySplashBinding
import com.dicoding.movieapp.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this@SplashActivity,HomeActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}