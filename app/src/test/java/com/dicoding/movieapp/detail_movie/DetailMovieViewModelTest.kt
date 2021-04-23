package com.dicoding.movieapp.detail_movie

import com.dicoding.movieapp.data.MovieDetailEntity
import com.dicoding.movieapp.data.MovieEntity
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.DetailDataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailMovieViewModelTest {
    private lateinit var mainViewModel: DetailMovieViewModel
    private lateinit var dataDummy: DataDummy
    private lateinit var detailDataDummy: DetailDataDummy
    private lateinit var idArray: Array<String>

    @Before
    fun init(){
        mainViewModel = DetailMovieViewModel()
        dataDummy = DataDummy
        detailDataDummy = DetailDataDummy
        idArray = arrayOf("m1","m2","m3","m4","m5","m6","m7","m8","m9","m10")
    }

    @Test
    fun getBasicMovieDetailsById() {
        //Expectation
        val movieBasicDetailsExpectation = dataDummy.generateMovies()
        //Reality
        var movieBasicDetailsReality = ArrayList<MovieEntity?>()
        for (id in idArray){
            movieBasicDetailsReality.add(mainViewModel.getBasicMovieDetailsById(id))
        }
        assertEquals(movieBasicDetailsExpectation,movieBasicDetailsReality)
    }

    @Test
    fun getDetailsById() {
        //Expectation
        val movieDetailsExpectation = detailDataDummy.getMovieDetail()
        //Reality
        var movieDetailsReality = ArrayList<MovieDetailEntity?>()
        for (id in idArray){
            movieDetailsReality.add(mainViewModel.getDetailsById(id))
        }
        assertEquals(movieDetailsExpectation,movieDetailsReality)
    }
}