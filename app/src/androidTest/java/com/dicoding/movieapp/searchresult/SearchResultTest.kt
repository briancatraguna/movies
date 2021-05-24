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
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.movieapp.R
import com.dicoding.movieapp.home.HomeActivity
import com.dicoding.movieapp.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Test

class SearchResultTest{

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
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(14))
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
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
    }

    @Test
    fun detailMovies(){
        //Check whether edit text search is displayed and type in 'Mortal Kombat'
        onView(withId(R.id.edit_text_search)).check(matches(isDisplayed()))
        onView(withId(R.id.edit_text_search)).perform(typeText("Mortal Kombat"), closeSoftKeyboard())
        //Check whether search button is displayed and click
        onView(withId(R.id.btn_search)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_search)).perform(click())
        //Click and go to details activity
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        //Poster
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        //Title
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText("Mortal Kombat")))
        //Release data
        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(withText("2021-04-07")))
        //Rating
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        //Overview
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText("Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.")))
        //Length
        onView(withId(R.id.length)).check(matches(isDisplayed()))
        onView(withId(R.id.length)).check(matches(withText("110 m")))
        //Safe for kids
        onView(withId(R.id.img_safe)).check(matches(isDisplayed()))
        //Popularity
        onView(withId(R.id.popularity)).check(matches(isDisplayed()))
    }
    @Test
    fun detailShows(){
        //Check whether edit text search is displayed and type in 'Itaewon Class'
        onView(withId(R.id.edit_text_search)).check(matches(isDisplayed()))
        onView(withId(R.id.edit_text_search)).perform(typeText("Itaewon Class"), closeSoftKeyboard())
        //Check whether search button is displayed and click
        onView(withId(R.id.btn_search)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_search)).perform(click())
        //Click and go to details shows
        onView(ViewMatchers.withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        //Poster
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        //Title
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText("Itaewon Class")))
        //Release date
        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(withText("2020-01-31")))
        //Rating
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        //Overview
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText("In a colorful Seoul neighborhood, an ex-con and his friends fight a mighty foe to make their ambitious dreams for their street bar a reality.")))
        //Seasons
        onView(withId(R.id.length)).check(matches(isDisplayed()))
        onView(withId(R.id.length)).check(matches(withText("1")))
        //Episodes
        onView(withId(R.id.episodes)).check(matches(isDisplayed()))
        onView(withId(R.id.episodes)).check(matches(withText("16")))
        //Popularity
        onView(withId(R.id.popularity)).check(matches(isDisplayed()))
    }

}