package com.dicoding.movieapp.searchresult

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.remote.MoviesItem
import com.dicoding.movieapp.data.source.Repository
import com.dicoding.movieapp.data.source.remote.ShowsItem
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
class SearchResultViewModelTest {

    private lateinit var viewModel: SearchResultViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var moviesObserver: Observer<List<MoviesItem>>

    @Mock
    private lateinit var moviesStatusObserver: Observer<Boolean>

    @Mock
    private lateinit var showsObserver: Observer<List<ShowsItem>>

    @Mock
    private lateinit var showsStatusObserver: Observer<Boolean>

    @Before
    fun setUp(){
        viewModel = SearchResultViewModel(repository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateFakeMovieResponse()
        val movieExpectation = MutableLiveData<List<MoviesItem>>()
        movieExpectation.value = dummyMovies

        `when`(repository.getRemoteMovies("test")).thenReturn(movieExpectation)
        val movieReality = viewModel.getMovies("test")
        verify(repository).getRemoteMovies("test")
        assertNotNull(movieReality.value)
        assertEquals(movieExpectation.value,movieReality.value)

        viewModel.getMovies("test").observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyMovies)
    }

    @Test
    fun getStatusMovies() {
        val dummyStatusMovies = DataDummy.generateFakeMovieStatus()
        val statusMoviesExpectation = MutableLiveData<Boolean>()
        statusMoviesExpectation.value = dummyStatusMovies

        `when`(repository.getRemoteLoadingStatusMovies()).thenReturn(statusMoviesExpectation)
        val statusMoviesReality = viewModel.getStatusMovies()
        assertNotNull(statusMoviesReality.value)
        assertEquals(statusMoviesExpectation.value,statusMoviesReality.value)

        viewModel.getStatusMovies().observeForever(moviesStatusObserver)
        verify(moviesStatusObserver).onChanged(dummyStatusMovies)
    }

    @Test
    fun getShows() {
        val dummyShows = DataDummy.generateFakeShowResponse()
        val showExpectation = MutableLiveData<List<ShowsItem>>()
        showExpectation.value = dummyShows

        `when`(repository.getRemoteShows("test")).thenReturn(showExpectation)
        val showReality = viewModel.getShows("test")
        verify(repository).getRemoteShows("test")
        assertNotNull(showReality.value)
        assertEquals(showExpectation.value,showReality.value)

        viewModel.getShows("test").observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyShows)
    }

    @Test
    fun getStatusShows() {
        val dummyStatusShows = DataDummy.generateFakeShowStatus()
        val statusShowsExpectation = MutableLiveData<Boolean>()
        statusShowsExpectation.value = dummyStatusShows

        `when`(repository.getRemoteLoadingStatusShows()).thenReturn(statusShowsExpectation)
        val statusShowsReality = viewModel.getStatusShows()
        assertNotNull(statusShowsReality.value)
        assertEquals(statusShowsExpectation.value,statusShowsReality.value)

        viewModel.getStatusShows().observeForever(showsStatusObserver)
        verify(showsStatusObserver).onChanged(dummyStatusShows)
    }
}