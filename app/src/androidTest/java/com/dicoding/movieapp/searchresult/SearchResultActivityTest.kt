package com.dicoding.movieapp.searchresult

import android.app.Instrumentation
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.dicoding.movieapp.R
import com.dicoding.movieapp.home.HomeActivity
import com.dicoding.movieapp.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Test

class SearchResultActivityTest{

    @Before
    fun setUp(){
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }

    @Test
    fun searchMovies(){
        //Check whether edit text search is displayed and type in 'Mortal Kombat'
        onView(withId(R.id.edit_text_search)).check(matches(isDisplayed()))
        onView(withId(R.id.edit_text_search)).perform(typeText("Mortal Kombat"), closeSoftKeyboard())
        //Check whether search button is displayed and click
        onView(withId(R.id.btn_search)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_search)).perform(click())
        //Check whether RV is displayed
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(15))
    }

    @Test
    fun searchTvShows(){
        //Check whether edit text search is displayed and type in 'Mortal Kombat'
        onView(withId(R.id.edit_text_search)).check(matches(isDisplayed()))
        onView(withId(R.id.edit_text_search)).perform(typeText("Itaewon Class"), closeSoftKeyboard())
        //Check whether search button is displayed and click
        onView(withId(R.id.btn_search)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_search)).perform(click())
        //Check whether RV is displayed
        onView(ViewMatchers.withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
    }

}