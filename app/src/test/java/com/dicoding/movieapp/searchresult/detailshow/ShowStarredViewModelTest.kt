package com.dicoding.movieapp.searchresult.detailshow

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieapp.data.source.FavoriteShowRepository
import com.dicoding.movieapp.data.source.local.TVShowEntity
import com.dicoding.movieapp.data.source.local.room.shows.TvShowsRoomEntity
import com.dicoding.movieapp.data.source.remote.SearchDetailMovieResponse
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
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class ShowStarredViewModelTest {
    private lateinit var dataDummy: DataDummy

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var viewModel: ShowStarredViewModel

    @Mock
    private lateinit var showsObserver: Observer<List<TvShowsRoomEntity>>

    @Before
    fun init(){
        dataDummy = DataDummy
    }

    @Test
    fun getReadAllShows() {
        //Expectation
        val dummyListShows = dataDummy.getFakeShowRoomDatabase()
        val listShowsExpectation = MutableLiveData<List<TvShowsRoomEntity>>()
        listShowsExpectation.value = dummyListShows

        //Reality
        `when`(viewModel.readAllShows).thenReturn(listShowsExpectation)
        val listShowsReality = viewModel.readAllShows
        assertNotNull(listShowsReality.value)
        assertEquals(listShowsExpectation.value,listShowsReality.value)

        viewModel.readAllShows.observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyListShows)
    }

    @Test
    fun addShow() {
        //Expectation
        val dummyListShows = dataDummy.getFakeShowRoomDatabase()
        val listShowsExpectation = MutableLiveData<List<TvShowsRoomEntity>>()
        listShowsExpectation.value = dummyListShows

        val dummyShowAdded = dataDummy.getTvShowRoomEntity()

        `when`(viewModel.addShow(dummyShowAdded)).then {
            `when`(viewModel.readAllShows).thenReturn(listShowsExpectation)
        }
        viewModel.addShow(dummyShowAdded)
        val listShowsReality = viewModel.readAllShows
        assertNotNull(listShowsReality.value)
        assertEquals(listShowsExpectation.value,listShowsReality.value)

        viewModel.readAllShows.observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyListShows)
    }

    @Test
    fun delShowById() {
        val dummyListShows = dataDummy.getFakeShowRoomDatabase()
        val listShowsExpectation = MutableLiveData<List<TvShowsRoomEntity>>()
        listShowsExpectation.value = dummyListShows

        val dummyShowId = 101

        `when`(viewModel.delShowById(dummyShowId)).then {
            `when`(viewModel.readAllShows).thenReturn(listShowsExpectation)
        }
        viewModel.delShowById(dummyShowId)
        val listShowsReality = viewModel.readAllShows
        assertNotNull(listShowsReality.value)
        assertEquals(listShowsExpectation.value,listShowsReality.value)

        viewModel.readAllShows.observeForever(showsObserver)
        verify(showsObserver).onChanged(dummyListShows)
    }
}