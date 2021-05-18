package com.dicoding.movieapp.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.local.room.movies.MoviesRoomEntity
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
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
class FavoriteShowRepositoryTest {
    private lateinit var dataDummy: DataDummy

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: FavoriteShowRepository

    @Mock
    private lateinit var showsObserver: Observer<List<TvShowsRoomEntity>>

    @Before
    fun init(){
        dataDummy = DataDummy
    }

    @Test
    fun readAllShows() {
        //Expectation
        val dummyListShows = dataDummy.getFakeShowRoomDatabase()
        val listShowsExpectation = MutableLiveData<List<TvShowsRoomEntity>>()
        listShowsExpectation.value = dummyListShows

        //Reality
        `when`(repository.readAllShows).thenReturn(listShowsExpectation)
        val listShowsReality = repository.readAllShows
        assertNotNull(listShowsReality.value)
        assertEquals(listShowsExpectation.value,listShowsReality.value)

        repository.readAllShows.observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyListShows)
    }

    @Test
    fun addShows() {
        //Expectation
        val dummyListShows = dataDummy.getFakeShowRoomDatabase()
        val listShowsExpectation = MutableLiveData<List<TvShowsRoomEntity>>()
        listShowsExpectation.value = dummyListShows

        val dummyShowAdded = dataDummy.getTvShowRoomEntity()

        `when`(repository.addShows(dummyShowAdded)).then {
            `when`(repository.readAllShows).thenReturn(listShowsExpectation)
        }
        repository.addShows(dummyShowAdded)
        val listShowsReality = repository.readAllShows
        assertNotNull(listShowsReality.value)
        assertEquals(listShowsExpectation.value,listShowsReality.value)

        repository.readAllShows.observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyListShows)
    }

    @Test
    fun delShowById() {
        //Expectation
        val dummyListShows = dataDummy.getFakeShowRoomDatabase()
        val listShowsExpectation = MutableLiveData<List<TvShowsRoomEntity>>()
        listShowsExpectation.value = dummyListShows

        val dummyShowId = 101

        `when`(repository.delShowById(dummyShowId)).then {
            `when`(repository.readAllShows).thenReturn(listShowsExpectation)
        }
        repository.delShowById(dummyShowId)
        val listShowsReality = repository.readAllShows
        assertNotNull(listShowsReality.value)
        assertEquals(listShowsExpectation.value,listShowsReality.value)

        repository.readAllShows.observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyListShows)
    }
}