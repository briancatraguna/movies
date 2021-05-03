package com.dicoding.movieapp.searchresult.detailmovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.remote.Repository
import com.dicoding.movieapp.data.source.remote.SearchDetailMovieResponse
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
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var detailMovieObserver: Observer<SearchDetailMovieResponse>

    @Before
    fun setUp(){
        viewModel = DetailMovieViewModel(repository)
    }

    @Test
    fun getMovieById() {
        val dummyDetailMovie = DataDummy.generateFakeMovieDetailResponse()
        val detailMovieExpectation = MutableLiveData<SearchDetailMovieResponse>()
        detailMovieExpectation.value = dummyDetailMovie

        `when`(repository.getMovieDetailsById("123")).thenReturn(detailMovieExpectation)
        val detailMovieReality = viewModel.getMovieById("123")
        verify(repository).getMovieDetailsById("123")
        assertNotNull(detailMovieReality.value)
        assertEquals(detailMovieExpectation.value,detailMovieReality.value)

        viewModel.getMovieById("123").observeForever(detailMovieObserver)
        verify(detailMovieObserver).onChanged(dummyDetailMovie)
    }
}