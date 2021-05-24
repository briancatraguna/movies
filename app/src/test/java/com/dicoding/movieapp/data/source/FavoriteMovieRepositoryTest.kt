package com.dicoding.movieapp.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.fortesting.repository.FakeFavoriteMovieRepository
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
class FavoriteMovieRepositoryTest {
    private lateinit var dataDummy: DataDummy
    private lateinit var favoriteMovieRepository: FakeFavoriteMovieRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesObserver: Observer<ArrayList<MoviesRoomEntity>>

    @Before
    fun init(){
        dataDummy = DataDummy
        favoriteMovieRepository = FakeFavoriteMovieRepository()
    }

    @Test
    fun getReadAllMovies() {
        //Expectation
        val dummyListMovies = dataDummy.getFakeMovieRoomDatabase()
        val listMoviesExpectation = MutableLiveData<ArrayList<MoviesRoomEntity>>()
        listMoviesExpectation.value = dummyListMovies

        //Actual
        val listMoviesActual = favoriteMovieRepository.getReadAllMovies()
        assertNotNull(listMoviesActual)
        assertEquals(listMoviesExpectation.value,listMoviesActual.value)

        favoriteMovieRepository.getReadAllMovies().observeForever(moviesObserver)
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
        var listMoviesActual = favoriteMovieRepository.getReadAllMovies()
        favoriteMovieRepository.addMovie()
        assertNotNull(listMoviesActual)
        assertEquals(listMoviesExpectation.value,listMoviesActual.value)

        favoriteMovieRepository.getReadAllMovies().observeForever(moviesObserver)
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
        var listMoviesActual = favoriteMovieRepository.getReadAllMovies()
        favoriteMovieRepository.delMovieById()
        assertNotNull(listMoviesActual)
        assertEquals(listMoviesExpectation.value,listMoviesActual.value)

        favoriteMovieRepository.getReadAllMovies().observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyListMovies)
    }
}