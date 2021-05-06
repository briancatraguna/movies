package com.dicoding.movieapp.injection

import android.content.Context
import com.dicoding.movieapp.data.source.remote.RemoteDataSource
import com.dicoding.movieapp.data.source.Repository
import com.dicoding.movieapp.data.source.local.LocalDataSource

object Injection {
    fun provideRepository(context: Context): Repository {
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance()
        return Repository.getInstance(remoteDataSource,localDataSource)
    }
}