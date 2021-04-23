package com.dicoding.movieapp.detail_tvshow

import com.dicoding.movieapp.data.TVShowDetailEntity
import com.dicoding.movieapp.data.TVShowEntity
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.DetailDataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailShowViewModelTest {
    private lateinit var mainViewModel: DetailShowViewModel
    private lateinit var dataDummy: DataDummy
    private lateinit var detailDataDummy: DetailDataDummy
    private lateinit var idArray: Array<String>

    @Before
    fun init(){
        mainViewModel = DetailShowViewModel()
        dataDummy = DataDummy
        detailDataDummy = DetailDataDummy
        idArray = arrayOf("s1","s2","s3","s4","s5","s6","s7","s8","s9","s10")
    }

    @Test
    fun getBasicShowDetailsById() {
        //Expectation
        val showBasicDetailExpectation = dataDummy.generateTvShows()
        //Reality
        var showBasicDetailReality = ArrayList<TVShowEntity?>()
        for (id in idArray){
            showBasicDetailReality.add(mainViewModel.getBasicShowDetailsById(id))
        }
        assertEquals(showBasicDetailExpectation,showBasicDetailReality)
    }

    @Test
    fun getDetailsById() {
        //Expectation
        val showDetailExpectation = detailDataDummy.getShowDetail()
        //Reality
        var showDetailReality = ArrayList<TVShowDetailEntity?>()
        for (id in idArray){
            showDetailReality.add(mainViewModel.getDetailsById(id))
        }
        assertEquals(showDetailExpectation,showDetailReality)
    }
}