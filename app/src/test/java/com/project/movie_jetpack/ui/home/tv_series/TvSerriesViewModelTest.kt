package com.project.movie_jetpack.ui.home.tv_series

import com.project.movie_jetpack.ui.home.movie.MovieViewModel
import junit.framework.Assert
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class TvSerriesViewModelTest {

    private lateinit var viewModel: TvSerriesViewModel
    @Before
    fun setUp() {
        viewModel = TvSerriesViewModel()
    }

    @Test
    fun getMovie() {
        val courseEntities = viewModel.getSerries()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(10, courseEntities.size)
    }

}