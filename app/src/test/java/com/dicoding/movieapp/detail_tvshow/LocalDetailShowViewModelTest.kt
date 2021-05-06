package com.dicoding.movieapp.detail_tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.dicoding.movieapp.data.source.Repository
import com.dicoding.movieapp.data.source.local.LocalDataSource
import com.dicoding.movieapp.data.source.local.TVShowDetailEntity
import com.dicoding.movieapp.data.source.local.TVShowEntity
import com.dicoding.movieapp.data.source.remote.RemoteDataSource
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.DetailDataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LocalDetailShowViewModelTest {
    private lateinit var mainViewModel: LocalDetailShowViewModel
    private lateinit var dataDummy: DataDummy
    private lateinit var detailDataDummy: DetailDataDummy
    private lateinit var idArray: Array<String>

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Before
    fun init(){
        mainViewModel = LocalDetailShowViewModel(repository)
        dataDummy = DataDummy
        detailDataDummy = DetailDataDummy
        idArray = arrayOf("s1","s2","s3","s4","s5","s6","s7","s8","s9","s10")
    }

    @Test
    fun getBasicShowDetailsById() {
        //Expectation
        val expectedShowBasicDetails = dataDummy.generateTvShows()
        val showBasicDetailsExpectation = MutableLiveData<List<TVShowEntity>>()
        showBasicDetailsExpectation.value = expectedShowBasicDetails
        //Reality
        `when`(repository.getLocalShows()).thenReturn(showBasicDetailsExpectation)
        val showBasicDetailsReality = ArrayList<TVShowEntity?>()
        for (id in idArray){
            showBasicDetailsReality.add(mainViewModel.getBasicShowDetailsById(id))
        }
        assertEquals(showBasicDetailsExpectation.value,showBasicDetailsReality)
    }

    @Test
    fun getDetailsById() {
        //Expectation
        val expectedShowDetails = detailDataDummy.getShowDetail()
        val showDetailsExpectation = MutableLiveData<List<TVShowDetailEntity>>()
        showDetailsExpectation.value = expectedShowDetails
        //Reality
        `when`(repository.getLocalDetailShows()).thenReturn(showDetailsExpectation)
        val showDetailReality = ArrayList<TVShowDetailEntity?>()
        for (id in idArray){
            showDetailReality.add(mainViewModel.getDetailsById(id))
        }
        assertEquals(showDetailsExpectation.value,showDetailReality)
    }
}