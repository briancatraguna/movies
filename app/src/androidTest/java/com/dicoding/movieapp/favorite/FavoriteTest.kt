package com.dicoding.movieapp.favorite

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.movieapp.R
import com.dicoding.movieapp.home.HomeActivity
import com.dicoding.movieapp.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Test

class FavoriteTest {

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
    fun addDeleteMovie(){
        //Type in 'Mortal Kombat' and click search
        onView(withId(R.id.edit_text_search)).perform(typeText("Mortal Kombat"), closeSoftKeyboard())
        onView(withId(R.id.btn_search)).perform(click())
        //Click and go to details activity
        onView(withId(R.id.rv_movies)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //Check whether the star button is shown and click
        onView(withId(R.id.img_star)).check(matches(isDisplayed()))
        onView(withId(R.id.img_star)).perform(click())
        //Navigate back to home and navigate to profile activity
        pressBack()
        onView(withId(R.id.back_button)).check(matches(isDisplayed()))
        onView(withId(R.id.back_button)).perform(click())
        //Check whether profile is shown and click
        onView(withId(R.id.profile_picture)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_picture)).perform(click())
        //Check whether recycler view is displayed
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //Remove from favorites
        onView(withId(R.id.img_star)).check(matches(isDisplayed()))
        onView(withId(R.id.img_star)).perform(click())
        pressBack()
    }

    @Test
    fun addDeleteTvShow(){
        //Type in 'Itaewon Class' and click search
        onView(withId(R.id.edit_text_search)).perform(typeText("Itaewon Class"), closeSoftKeyboard())
        onView(withId(R.id.btn_search)).perform(click())
        //Click and go to details activity
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_shows)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //Check whether the star button is shown and click
        onView(withId(R.id.img_star)).check(matches(isDisplayed()))
        onView(withId(R.id.img_star)).perform(click())
        //Navigate back to home and navigate to profile activity
        pressBack()
        onView(withId(R.id.back_button)).check(matches(isDisplayed()))
        onView(withId(R.id.back_button)).perform(click())
        //Check whether profile is shown and click
        onView(withId(R.id.profile_picture)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_picture)).perform(click())
        //Check whether recycler view is displayed
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //Remove from favorites
        onView(withId(R.id.img_star)).check(matches(isDisplayed()))
        onView(withId(R.id.img_star)).perform(click())
        pressBack()
    }

}