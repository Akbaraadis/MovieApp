package com.project.movie_jetpack.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.utils.EspressoIdlingResource
import com.project.movie_jetpack.data.utils.MoviesData
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val moviesData = MoviesData.generateMovies()
    private val seriesData = MoviesData.generateSerries()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.movie_rv_list)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_rv_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(moviesData.size))
    }

    @Test
    fun loadSeries() {
        onView(withText("Tv Series")).perform(click())
        onView(withId(R.id.series_rv_list)).check(matches(isDisplayed()))
        onView(withId(R.id.series_rv_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(seriesData.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.movie_rv_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.detail_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_title)).check(matches(withText("Mortal Kombat")))
        onView(withId(R.id.detail_tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_genre)).check(matches(withText("Fantasi, Aksi, Petualangan, Cerita Fiksi, Cerita Seru")))
        onView(withId(R.id.detail_tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_release)).check(matches(withText("07/04/2021")))
        onView(withId(R.id.detail_tv_sinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_sinopsis)).check(matches(withText("Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.")))
        onView(withId(R.id.detail_iv_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailSeries() {
        onView(withText("Tv Series")).perform(click())
        onView(withId(R.id.series_rv_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.detail_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_title)).check(matches(withText("I Am Not an Animal")))
        onView(withId(R.id.detail_tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_genre)).check(matches(withText("Animasi, Komedi")))
        onView(withId(R.id.detail_tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_release)).check(matches(withText("2004")))
        onView(withId(R.id.detail_tv_sinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_sinopsis)).check(matches(withText("I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.")))
        onView(withId(R.id.detail_iv_poster)).check(matches(isDisplayed()))
     }



}