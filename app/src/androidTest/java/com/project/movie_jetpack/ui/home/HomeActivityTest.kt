package com.project.movie_jetpack.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.utils.MoviesData
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val moviesData = MoviesData.generateMovies()
    private val seriesData = MoviesData.generateSerries()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.movie_rv_list)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_rv_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(moviesData.size))
    }

    @Test
    fun loadSeries() {
        onView(withId(R.id.series_rv_list)).check(matches(isDisplayed()))
        onView(withId(R.id.series_rv_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(seriesData.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.movie_rv_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.detail_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_title)).check(matches(withText(moviesData[0].title)))
        onView(withId(R.id.detail_tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_genre)).check(matches(withText(moviesData[0].genre)))
        onView(withId(R.id.detail_tv_sinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_sinopsis)).check(matches(withText(moviesData[0].sinopsis)))
        onView(withId(R.id.detail_iv_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailSeries() {
        onView(withId(R.id.series_rv_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.detail_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_title)).check(matches(withText(seriesData[0].title)))
        onView(withId(R.id.detail_tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_genre)).check(matches(withText(seriesData[0].genre)))
        onView(withId(R.id.detail_tv_sinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_sinopsis)).check(matches(withText(seriesData[0].sinopsis)))
        onView(withId(R.id.detail_iv_poster)).check(matches(isDisplayed()))
     }



}