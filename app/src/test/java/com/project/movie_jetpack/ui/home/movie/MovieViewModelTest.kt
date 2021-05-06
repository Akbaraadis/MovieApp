package com.project.movie_jetpack.ui.home.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.utils.MoviesData
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepo: MovieRepo

    @Mock
    private lateinit var observer: Observer<List<Movies>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepo)
    }

    @Test
    fun getMovie() {
        val dataMovie = MoviesData.generateMovies()
        val movies = MutableLiveData<List<Movies>>()
        movies.value = dataMovie

        `when`(movieRepo.getAllMovie()).thenReturn(movies)
        val courseEntities = viewModel.getMovie().value
        verify(movieRepo).getAllMovie()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities?.size)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dataMovie)
    }

}