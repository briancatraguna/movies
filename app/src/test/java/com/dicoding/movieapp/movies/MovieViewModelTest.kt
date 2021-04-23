package com.dicoding.movieapp.movies

import com.dicoding.movieapp.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {
    private lateinit var mainViewModel: MovieViewModel
    private lateinit var dataDummy: DataDummy
    private lateinit var idArray: Array<String>

    @Before
    fun init(){
        mainViewModel = MovieViewModel()
        dataDummy = DataDummy
        idArray = arrayOf("m1","m2","m3","m4","m5","m6","m7","m8","m9","m10")
    }

    @Test
    fun getMovies() {
        //Expectation
        val movieExpectation = dataDummy.generateMovies()
        //Reality
        val movieReality = mainViewModel.getMovies()
        assertEquals(movieExpectation,movieReality)
    }
}