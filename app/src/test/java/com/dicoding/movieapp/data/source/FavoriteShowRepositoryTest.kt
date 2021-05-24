package com.dicoding.movieapp.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.fortesting.repository.FakeFavoriteShowsRepository
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
class FavoriteShowRepositoryTest {
    private lateinit var dataDummy: DataDummy
    private lateinit var favoriteShowRepository: FakeFavoriteShowsRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showsObserver: Observer<List<TvShowsRoomEntity>>

    @Before
    fun init(){
        dataDummy = DataDummy
        favoriteShowRepository = FakeFavoriteShowsRepository()
    }

    @Test
    fun readAllShows() {
        //Expectation
        val dummyListShows = dataDummy.getFakeShowRoomDatabase()
        val listShowsExpectation = MutableLiveData<ArrayList<TvShowsRoomEntity>>()
        listShowsExpectation.value = dummyListShows

        //Actual
        val listShowsActual = favoriteShowRepository.readAllShows()
        assertNotNull(listShowsActual)
        assertEquals(listShowsExpectation.value,listShowsActual.value)

        favoriteShowRepository.readAllShows().observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyListShows)
    }

    @Test
    fun addShows() {
        //Expectation
        val dummyListShows = dataDummy.getFakeShowRoomDatabase()
        val listShowsExpectation = MutableLiveData<ArrayList<TvShowsRoomEntity>>()
        listShowsExpectation.value = dummyListShows
        listShowsExpectation.value!!.add(dataDummy.getTvShowRoomEntity())

        //Actual
        val listShowsActual = favoriteShowRepository.readAllShows()
        favoriteShowRepository.addShows()
        assertNotNull(listShowsActual)
        assertEquals(listShowsExpectation.value,listShowsActual.value)

        favoriteShowRepository.readAllShows().observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyListShows)
    }

    @Test
    fun delShowById() {
        //Expectation
        val dummyListShows = dataDummy.getFakeShowRoomDatabase()
        val listShowsExpectation = MutableLiveData<ArrayList<TvShowsRoomEntity>>()
        listShowsExpectation.value = dummyListShows
        listShowsExpectation.value!!.removeAt(0)

        //Actual
        val listShowsActual = favoriteShowRepository.readAllShows()
        favoriteShowRepository.delShowById()
        assertNotNull(listShowsActual)
        assertEquals(listShowsExpectation.value,listShowsActual.value)

        favoriteShowRepository.readAllShows().observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyListShows)
    }
}