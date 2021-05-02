package com.project.movie_jetpack.ui.home.tv_series

import junit.framework.Assert
import org.junit.Before
import org.junit.Test

class TvSeriesViewModelTest {

    private lateinit var viewModel: TvSeriesViewModel
    @Before
    fun setUp() {
        viewModel = TvSeriesViewModel()
    }

    @Test
    fun getMovie() {
        val courseEntities = viewModel.getSerries()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(10, courseEntities.size)
    }

}