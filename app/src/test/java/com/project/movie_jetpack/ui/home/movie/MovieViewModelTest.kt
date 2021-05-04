package com.project.movie_jetpack.ui.home.movie

import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.utils.MoviesData
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var movieRepo: MovieRepo

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepo)
    }

    @Test
    fun getMovie() {
        `when`(movieRepo.getAllMovie()).thenReturn(MoviesData.generateMovies() as ArrayList<Movies>)
        val courseEntities = viewModel.getMovie()
        verify(movieRepo).getAllMovie()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities.size)
    }

}