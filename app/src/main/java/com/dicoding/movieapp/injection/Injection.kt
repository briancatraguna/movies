package com.dicoding.movieapp.injection

import android.content.Context
import com.dicoding.movieapp.data.source.remote.RemoteDataSource
import com.dicoding.movieapp.data.source.remote.Repository

object Injection {
    fun provideRepository(context: Context): Repository{
        val remoteDataSource = RemoteDataSource.getInstance()
        return Repository.getInstance(remoteDataSource)
    }
}