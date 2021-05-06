package com.dicoding.movieapp.detail_movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.Repository
import com.dicoding.movieapp.data.source.local.LocalDataSource
import com.dicoding.movieapp.data.source.local.MovieDetailEntity
import com.dicoding.movieapp.data.source.local.MovieEntity
import com.dicoding.movieapp.data.source.remote.RemoteDataSource
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.DetailDataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LocalDetailMovieViewModelTest {
    private lateinit var mainViewModel: LocalDetailMovieViewModel
    private lateinit var dataDummy: DataDummy
    private lateinit var detailDataDummy: DetailDataDummy
    private lateinit var idArray: Array<String>

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Before
    fun init(){
        mainViewModel = LocalDetailMovieViewModel(repository)
        dataDummy = DataDummy
        detailDataDummy = DetailDataDummy
        idArray = arrayOf("m1","m2","m3","m4","m5","m6","m7","m8","m9","m10")
    }

    @Test
    fun getBasicMovieDetailsById() {
        //Expectation
        val expectedMovieBasicDetails = dataDummy.generateMovies()
        val movieBasicDetailsExpectation = MutableLiveData<List<MovieEntity>>()
        movieBasicDetailsExpectation.value = expectedMovieBasicDetails
        //Reality
        `when`(repository.getLocalMovies()).thenReturn(movieBasicDetailsExpectation)
        val movieBasicDetailsReality = ArrayList<MovieEntity?>()
        for (id in idArray){
            movieBasicDetailsReality.add(mainViewModel.getBasicMovieDetailsById(id))
        }
        assertEquals(movieBasicDetailsExpectation.value,movieBasicDetailsReality)
    }

    @Test
    fun getDetailsById() {
        //Expectation
        val expectedMovieDetails = detailDataDummy.getMovieDetail()
        val movieDetailsExpectation = MutableLiveData<List<MovieDetailEntity>>()
        movieDetailsExpectation.value = expectedMovieDetails
        //Reality
        `when`(repository.getLocalDetailMovies()).thenReturn(movieDetailsExpectation)
        val movieDetailsReality = ArrayList<MovieDetailEntity?>()
        for (id in idArray){
            movieDetailsReality.add(mainViewModel.getDetailsById(id))
        }
        assertEquals(movieDetailsExpectation.value,movieDetailsReality)
    }
}