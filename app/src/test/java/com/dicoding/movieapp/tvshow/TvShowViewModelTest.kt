package com.dicoding.movieapp.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.Repository
import com.dicoding.movieapp.data.source.local.LocalDataSource
import com.dicoding.movieapp.data.source.local.TVShowEntity
import com.dicoding.movieapp.data.source.remote.RemoteDataSource
import com.dicoding.movieapp.utils.DataDummy
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
class TvShowViewModelTest {
    private lateinit var mainViewModel: TvShowViewModel
    private lateinit var dataDummy: DataDummy

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var showsObserver: Observer<List<TVShowEntity>>

    @Before
    fun init(){
        mainViewModel = TvShowViewModel(repository)
        dataDummy = DataDummy
    }

    @Test
    fun getTvShows() {
        //Expectation
        val expectedShows = dataDummy.generateTvShows()
        val showExpectation = MutableLiveData<List<TVShowEntity>>()
        showExpectation.value = expectedShows
        //Reality
        `when`(repository.getLocalShows()).thenReturn(showExpectation)
        val showReality = mainViewModel.getTvShows()
        verify(repository).getLocalShows()
        assertNotNull(showReality.value)
        assertEquals(showExpectation.value,showReality.value)

        mainViewModel.getTvShows().observeForever(showsObserver)
        verify(showsObserver).onChanged(expectedShows)
    }
}