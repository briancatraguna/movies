package com.dicoding.movieapp.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.Repository
import com.dicoding.movieapp.data.source.local.MovieDetailEntity
import com.dicoding.movieapp.data.source.local.MovieEntity
import com.dicoding.movieapp.data.source.local.TVShowDetailEntity
import com.dicoding.movieapp.data.source.local.TVShowEntity
import com.dicoding.movieapp.data.source.remote.MoviesItem
import com.dicoding.movieapp.data.source.remote.SearchDetailMovieResponse
import com.dicoding.movieapp.data.source.remote.SearchDetailShowResponse
import com.dicoding.movieapp.data.source.remote.ShowsItem
import com.dicoding.movieapp.movies.MovieViewModel
import com.dicoding.movieapp.tvshow.TvShowViewModel
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.DetailDataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepositoryTest {
    //DataDummies
    private lateinit var dataDummy: DataDummy
    private lateinit var detailDataDummy: DetailDataDummy

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var moviesObserver: Observer<List<MoviesItem>>

    @Mock
    private lateinit var showsObserver: Observer<List<ShowsItem>>

    @Mock
    private lateinit var moviesStatusObserver: Observer<Boolean>

    @Mock
    private lateinit var showsStatusObserver: Observer<Boolean>

    @Mock
    private lateinit var detailMovieObserver: Observer<SearchDetailMovieResponse>

    @Mock
    private lateinit var detailShowObserver: Observer<SearchDetailShowResponse>

    @Before
    fun setUp(){
        dataDummy = DataDummy
        detailDataDummy = DetailDataDummy

    }

    @Test
    fun getRemoteMovies() {
        val dummyMovies = DataDummy.generateFakeMovieResponse()
        val movieExpectation = MutableLiveData<List<MoviesItem>>()
        movieExpectation.value = dummyMovies

        `when`(repository.getRemoteMovies("test")).thenReturn(movieExpectation)
        val movieReality = repository.getRemoteMovies("test")
        verify(repository).getRemoteMovies("test")
        assertNotNull(movieReality.value)
        assertEquals(movieExpectation.value,movieReality.value)

        repository.getRemoteMovies("test").observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyMovies)
    }

    @Test
    fun getRemoteLoadingStatusMovies() {
        val dummyStatusMovies = DataDummy.generateFakeMovieStatus()
        val statusMoviesExpectation = MutableLiveData<Boolean>()
        statusMoviesExpectation.value = dummyStatusMovies

        `when`(repository.getRemoteLoadingStatusMovies()).thenReturn(statusMoviesExpectation)
        val statusMoviesReality = repository.getRemoteLoadingStatusMovies()
        assertNotNull(statusMoviesReality.value)
        assertEquals(statusMoviesExpectation.value,statusMoviesReality.value)

        repository.getRemoteLoadingStatusMovies().observeForever(moviesStatusObserver)
        verify(moviesStatusObserver).onChanged(dummyStatusMovies)
    }

    @Test
    fun getRemoteShows() {
        val dummyShows = DataDummy.generateFakeShowResponse()
        val showExpectation = MutableLiveData<List<ShowsItem>>()
        showExpectation.value = dummyShows

        `when`(repository.getRemoteShows("test")).thenReturn(showExpectation)
        val showReality = repository.getRemoteShows("test")
        verify(repository).getRemoteShows("test")
        assertNotNull(showReality.value)
        assertEquals(showExpectation.value,showReality.value)

        repository.getRemoteShows("test").observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyShows)
    }

    @Test
    fun getRemoteLoadingStatusShows() {
        val dummyStatusShows = DataDummy.generateFakeShowStatus()
        val statusShowsExpectation = MutableLiveData<Boolean>()
        statusShowsExpectation.value = dummyStatusShows

        `when`(repository.getRemoteLoadingStatusShows()).thenReturn(statusShowsExpectation)
        val statusShowsReality = repository.getRemoteLoadingStatusShows()
        assertNotNull(statusShowsReality.value)
        assertEquals(statusShowsExpectation.value,statusShowsReality.value)

        repository.getRemoteLoadingStatusShows().observeForever(showsStatusObserver)
        verify(showsStatusObserver).onChanged(dummyStatusShows)
    }

    @Test
    fun getRemoteMovieDetailsById() {
        val dummyDetailMovie = DataDummy.generateFakeMovieDetailResponse()
        val detailMovieExpectation = MutableLiveData<SearchDetailMovieResponse>()
        detailMovieExpectation.value = dummyDetailMovie

        `when`(repository.getRemoteMovieDetailsById("123")).thenReturn(detailMovieExpectation)
        val detailMovieReality = repository.getRemoteMovieDetailsById("123")
        verify(repository).getRemoteMovieDetailsById("123")
        assertNotNull(detailMovieReality.value)
        assertEquals(detailMovieExpectation.value,detailMovieReality.value)

        repository.getRemoteMovieDetailsById("123").observeForever(detailMovieObserver)
        verify(detailMovieObserver).onChanged(dummyDetailMovie)
    }

    @Test
    fun getRemoteShowDetailsById() {
        val dummyDetailShows = DataDummy.generateFakeShowDetailResponse()
        val detailShowExpectation = MutableLiveData<SearchDetailShowResponse>()
        detailShowExpectation.value = dummyDetailShows

        `when`(repository.getRemoteShowDetailsById("123")).thenReturn(detailShowExpectation)
        val detailShowReality = repository.getRemoteShowDetailsById("123")
        Mockito.verify(repository).getRemoteShowDetailsById("123")
        assertNotNull(detailShowReality.value)
        assertEquals(detailShowExpectation.value,detailShowReality.value)

        repository.getRemoteShowDetailsById("123").observeForever(detailShowObserver)
        Mockito.verify(detailShowObserver).onChanged(dummyDetailShows)
    }

    @Test
    fun getLocalMovies() {
        //Expectation
        val expectedMovies = dataDummy.generateMovies()
        val movieExpecation = MutableLiveData<List<MovieEntity>>()
        movieExpecation.value = expectedMovies
        //Reality
        Mockito.`when`(repository.getLocalMovies()).thenReturn(movieExpecation)
        val movieReality = repository.getLocalMovies()
        verify(repository).getLocalMovies()
        assertNotNull(movieReality.value)
        assertEquals(movieExpecation.value,movieReality.value)
    }

    @Test
    fun getLocalShows() {
        //Expectation
        val expectedShows = dataDummy.generateTvShows()
        val showExpectation = MutableLiveData<List<TVShowEntity>>()
        showExpectation.value = expectedShows
        //Reality
        Mockito.`when`(repository.getLocalShows()).thenReturn(showExpectation)
        val showReality = repository.getLocalShows()
        verify(repository).getLocalShows()
        assertNotNull(showReality.value)
        assertEquals(showExpectation.value,showReality.value)
    }

    @Test
    fun getLocalDetailMovies() {
        //Expectation
        val expectedDetailMovies = detailDataDummy.getMovieDetail()
        val movieDetailExpectation = MutableLiveData<List<MovieDetailEntity>>()
        movieDetailExpectation.value = expectedDetailMovies
        //Reality
        `when`(repository.getLocalDetailMovies()).thenReturn(movieDetailExpectation)
        val movieDetailReality = repository.getLocalDetailMovies()
        verify(repository).getLocalDetailMovies()
        assertNotNull(movieDetailReality.value)
        assertEquals(movieDetailExpectation.value,movieDetailReality.value)
    }

    @Test
    fun getLocalDetailShows() {
        //Expectation
        val expectedDetailShows = detailDataDummy.getShowDetail()
        val showDetailExpectation = MutableLiveData<List<TVShowDetailEntity>>()
        showDetailExpectation.value = expectedDetailShows
        //Reality
        `when`(repository.getLocalDetailShows()).thenReturn(showDetailExpectation)
        val showDetailReality = repository.getLocalDetailShows()
        verify(repository).getLocalDetailShows()
        assertNotNull(showDetailReality.value)
        assertEquals(showDetailExpectation.value,showDetailReality.value)
    }
}