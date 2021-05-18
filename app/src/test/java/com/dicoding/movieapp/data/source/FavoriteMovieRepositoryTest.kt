package com.dicoding.movieapp.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import com.dicoding.movieapp.utils.DataDummy
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

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: FavoriteMovieRepository

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
        `when`(repository.readAllMovies).thenReturn(listMoviesExpectation)
        val listMoviesReality = repository.readAllMovies
        assertNotNull(listMoviesReality.value)
        assertEquals(listMoviesExpectation.value,listMoviesReality.value)

        repository.readAllMovies.observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyListMovies)
    }

    @Test
    fun addMovie() {
        //Expectation
        val dummyListMovies = dataDummy.getFakeMovieRoomDatabase()
        val listMoviesExpectation = MutableLiveData<List<MoviesRoomEntity>>()
        listMoviesExpectation.value = dummyListMovies

        val dummyMovieAdded = dataDummy.getMovieRoomEntity()

        `when`(repository.addMovie(dummyMovieAdded)).then {
            `when`(repository.readAllMovies).thenReturn(listMoviesExpectation)
        }
        repository.addMovie(dummyMovieAdded)
        val listMoviesReality = repository.readAllMovies
        assertNotNull(listMoviesReality.value)
        assertEquals(listMoviesExpectation.value,listMoviesReality.value)

        repository.readAllMovies.observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyListMovies)
    }

    @Test
    fun delMovieById() {
        //Expectation
        val dummyListMovies = dataDummy.getFakeMovieRoomDatabase()
        val listMoviesExpectation = MutableLiveData<List<MoviesRoomEntity>>()
        listMoviesExpectation.value = dummyListMovies

        val dummyMovieId = 101

        `when`(repository.delMovieById(dummyMovieId)).then {
            `when`(repository.readAllMovies).thenReturn(listMoviesExpectation)
        }
        repository.delMovieById(dummyMovieId)
        val listMoviesReality = repository.readAllMovies
        assertNotNull(listMoviesReality.value)
        assertEquals(listMoviesExpectation.value,listMoviesReality.value)

        repository.readAllMovies.observeForever(moviesObserver)
        Mockito.verify(moviesObserver).onChanged(dummyListMovies)
    }
}