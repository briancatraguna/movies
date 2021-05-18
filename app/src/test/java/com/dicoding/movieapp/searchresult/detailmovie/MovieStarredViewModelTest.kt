package com.dicoding.movieapp.searchresult.detailmovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
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
class MovieStarredViewModelTest {
    private lateinit var dataDummy: DataDummy

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var viewModel: MovieStarredViewModel

    @Mock
    private lateinit var moviesObserver: Observer<List<MoviesRoomEntity>>

    @Before
    fun init(){
        dataDummy = DataDummy
    }

    @Test
    fun getReadAllMovies() {
        //Expectation
        val dummyListMovies = dataDummy.getFakeMovieRoomDatabase()
        val listMoviesExpectation = MutableLiveData<List<MoviesRoomEntity>>()
        listMoviesExpectation.value = dummyListMovies

        //Reality
        `when`(viewModel.readAllMovies).thenReturn(listMoviesExpectation)
        val listMoviesReality = viewModel.readAllMovies
        assertNotNull(listMoviesReality.value)
        assertEquals(listMoviesExpectation.value,listMoviesReality.value)

        viewModel.readAllMovies.observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyListMovies)
    }

    @Test
    fun addMovie() {
        //Expectation
        val dummyListMovies = dataDummy.getFakeMovieRoomDatabase()
        val listMoviesExpectation = MutableLiveData<List<MoviesRoomEntity>>()
        listMoviesExpectation.value = dummyListMovies

        val dummyMovieAdded = dataDummy.getMovieRoomEntity()

        `when`(viewModel.addMovie(dummyMovieAdded)).then {
            `when`(viewModel.readAllMovies).thenReturn(listMoviesExpectation)
        }
        viewModel.addMovie(dummyMovieAdded)
        val listMoviesReality = viewModel.readAllMovies
        assertNotNull(listMoviesReality.value)
        assertEquals(listMoviesExpectation.value,listMoviesReality.value)

        viewModel.readAllMovies.observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyListMovies)
    }

    @Test
    fun delMovieById() {
        //Expectation
        val dummyListMovies = dataDummy.getFakeMovieRoomDatabase()
        val listMoviesExpectation = MutableLiveData<List<MoviesRoomEntity>>()
        listMoviesExpectation.value = dummyListMovies

        val dummyMovieId = 101

        `when`(viewModel.delMovieById(dummyMovieId)).then {
            `when`(viewModel.readAllMovies).thenReturn(listMoviesExpectation)
        }
        viewModel.delMovieById(dummyMovieId)
        val listMoviesReality = viewModel.readAllMovies
        assertNotNull(listMoviesReality.value)
        assertEquals(listMoviesExpectation.value,listMoviesReality.value)

        viewModel.readAllMovies.observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyListMovies)
    }
}