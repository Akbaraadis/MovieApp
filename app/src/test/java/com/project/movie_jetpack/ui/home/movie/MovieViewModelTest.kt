package com.project.movie_jetpack.ui.home.movie

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovie() {
        val courseEntities = viewModel.getMovie()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities.size)
    }

}