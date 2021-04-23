package com.dicoding.movieapp.home

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicoding.movieapp.R
import com.dicoding.movieapp.utils.DataDummy
import com.dicoding.movieapp.utils.DetailDataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{

    private val dummyMovies = DataDummy.generateMovies()
    private val detailMovies = DetailDataDummy.getMovieDetail()
    private val dummyShows = DataDummy.generateTvShows()
    private val detailShows = DetailDataDummy.getShowDetail()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies(){
        //Movies data in RV
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovies(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        //Title
        onView(withId(R.id.tv_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title)).check(matches(withText(dummyMovies[0].title)))
        //Avatar
        onView(withId(R.id.movieAvatar)).check(matches(isDisplayed()))
        //Director
        onView(withId(R.id.author)).check(matches(isDisplayed()))
        onView(withId(R.id.author)).check(matches(withText("By ${detailMovies[0].director}")))
        //TrailerThumbnail
        onView(withId(R.id.img_trailer)).check(matches(isDisplayed()))
        //Stars
        onView(withId(R.id.stars_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.stars_detail)).check(matches(withText(dummyMovies[0].rating)))
        //Overview
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(detailMovies[0].overview)))
        //Cast list
        onView(withId(R.id.lv_cast)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShows(){
        //Shows Data in RV
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShows.size))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
    }

    @Test
    fun loadDetailShows(){
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //Title
        onView(withId(R.id.tv_show_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_title)).check(matches(withText(dummyShows[0].title)))
        //Avatar
        onView(withId(R.id.showAvatar)).check(matches(isDisplayed()))
        //Director
        onView(withId(R.id.author)).check(matches(isDisplayed()))
        onView(withId(R.id.author)).check(matches(withText("By ${detailShows[0].director}")))
        //TrailerThumbnail
        onView(withId(R.id.img_trailer)).check(matches(isDisplayed()))
        //Stars
        onView(withId(R.id.stars_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.stars_detail)).check(matches(withText(dummyShows[0].rating)))
        //Overview
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(detailShows[0].overview)))
        //Cast list
        onView(withId(R.id.lv_cast)).check(matches(isDisplayed()))
    }
}