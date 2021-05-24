package com.dicoding.movieapp.searchresult.detailmovie

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.fortesting.viewmodel.FakeMovieStarredViewModel
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
class MovieStarredViewModelTest {
    private lateinit var dataDummy: DataDummy
    private lateinit var viewModel: FakeMovieStarredViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesObserver: Observer<ArrayList<MoviesRoomEntity>>

    @Before
    fun init(){
        viewModel = FakeMovieStarredViewModel()
        dataDummy = DataDummy
    }

    @Test
    fun getReadAllMovies() {
        //Expectation
        val dummyListMovies = dataDummy.getFakeMovieRoomDatabase()
        val listMoviesExpectation = MutableLiveData<List<MoviesRoomEntity>>()
        listMoviesExpectation.value = dummyListMovies

        //Actual
        val listMoviesActual = viewModel.getReadAllMovies()
        assertNotNull(listMoviesActual)
        assertEquals(listMoviesExpectation.value,listMoviesActual.value)

        viewModel.getReadAllMovies().observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyListMovies)
    }

    @Test
    fun addMovie() {
        //Expectation
        val dummyListMovies = dataDummy.getFakeMovieRoomDatabase()
        val listMoviesExpectation = MutableLiveData<ArrayList<MoviesRoomEntity>>()
        listMoviesExpectation.value = dummyListMovies
        listMoviesExpectation.value!!.add(dataDummy.getMovieRoomEntity())

        //Actual
        var listMoviesActual = viewModel.getReadAllMovies()
        viewModel.addMovie()
        assertNotNull(listMoviesActual)
        assertEquals(listMoviesExpectation.value,listMoviesActual.value)

        viewModel.getReadAllMovies().observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyListMovies)
    }

    @Test
    fun delMovieById() {
        //Expectation
        val dummyListMovies = dataDummy.getFakeMovieRoomDatabase()
        val listMoviesExpectation = MutableLiveData<ArrayList<MoviesRoomEntity>>()
        listMoviesExpectation.value = dummyListMovies
        listMoviesExpectation.value!!.removeAt(0)

        //Actual
        var listMoviesActual = viewModel.getReadAllMovies()
        viewModel.delMovieById()
        assertNotNull(listMoviesActual)
        assertEquals(listMoviesExpectation.value,listMoviesActual.value)

        viewModel.getReadAllMovies().observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyListMovies)

    }
}