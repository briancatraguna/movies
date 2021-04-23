package com.dicoding.movieapp.tvshow

import com.dicoding.movieapp.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {
    private lateinit var mainViewModel: TvShowViewModel
    private lateinit var dataDummy: DataDummy
    private lateinit var idArray: Array<String>

    @Before
    fun init(){
        mainViewModel = TvShowViewModel()
        dataDummy = DataDummy
        idArray = arrayOf("s1","s2","s3","s4","s5","s6","s7","s8","s9","s10")
    }

    @Test
    fun getTvShows() {
        //Expectation
        val showExpectation = dataDummy.generateTvShows()
        //Reality
        val showReality = mainViewModel.getTvShows()
        assertEquals(showExpectation,showReality)
    }
}