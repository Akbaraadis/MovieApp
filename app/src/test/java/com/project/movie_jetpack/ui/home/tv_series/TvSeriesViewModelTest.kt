package com.project.movie_jetpack.ui.home.tv_series

import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.utils.MoviesData
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvSeriesViewModelTest {

    private lateinit var viewModel: TvSeriesViewModel

    @Mock
    private lateinit var movieRepo: MovieRepo

    @Before
    fun setUp() {
        viewModel = TvSeriesViewModel(movieRepo)
    }

    @Test
    fun getMovie() {
        `when`(movieRepo.getAllSeries()).thenReturn(MoviesData.generateSerries() as ArrayList<Movies>)
        val courseEntities = viewModel.getSerries()
        verify(movieRepo).getAllSeries()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities.size)
    }

}