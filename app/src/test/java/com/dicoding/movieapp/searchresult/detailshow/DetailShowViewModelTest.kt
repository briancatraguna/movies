package com.dicoding.movieapp.searchresult.detailshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.remote.Repository
import com.dicoding.movieapp.data.source.remote.SearchDetailShowResponse
import com.dicoding.movieapp.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailShowViewModelTest {

    private lateinit var viewModel: DetailShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var detailShowObserver: Observer<SearchDetailShowResponse>

    @Before
    fun setUp(){
        viewModel = DetailShowViewModel(repository)
    }

    @Test
    fun getShowById() {
        val dummyDetailShows = DataDummy.generateFakeShowDetailResponse()
        val detailShowExpectation = MutableLiveData<SearchDetailShowResponse>()
        detailShowExpectation.value = dummyDetailShows

        `when`(repository.getShowDetailsById("123")).thenReturn(detailShowExpectation)
        val detailShowReality = viewModel.getShowById("123")
        verify(repository).getShowDetailsById("123")
        assertNotNull(detailShowReality.value)
        assertEquals(detailShowExpectation.value,detailShowReality.value)

        viewModel.getShowById("123").observeForever(detailShowObserver)
        verify(detailShowObserver).onChanged(dummyDetailShows)
    }
}