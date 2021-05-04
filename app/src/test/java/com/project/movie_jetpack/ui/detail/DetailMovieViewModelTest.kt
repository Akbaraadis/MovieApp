package com.project.movie_jetpack.ui.detail

import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.utils.MoviesData
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest{

    private lateinit var viewModel: DetailMovieViewModel
    private val movies = MoviesData.generateMovies()[0]
    private val movieId = movies.moviesId

    private val series = MoviesData.generateSerries()[0]
    private val seriesId = series.moviesId

    @Mock
    private lateinit var movieRepo: MovieRepo

    @Before
    fun setUpMovie() {
        viewModel = DetailMovieViewModel(movieRepo)
        viewModel.setSelectedMovie(movieId)
    }

    @Before
    fun setUpSeries() {
        viewModel = DetailMovieViewModel(movieRepo)
        viewModel.setSelectedMovie(seriesId)
    }

    @Test
    fun getMovie() {
        `when`(movieRepo.getAllMovie()).thenReturn(MoviesData.generateMovies() as ArrayList<Movies>)
        viewModel.setSelectedMovie(movies.moviesId)
        val movie = viewModel.getMovie()
        verify(movieRepo).getAllMovie()
        assertNotNull(movie)
        assertEquals(movies.moviesId, movie.moviesId)
        assertEquals(movies.genre, movie.genre)
        assertEquals(movies.sinopsis, movie.sinopsis)
        assertEquals(movies.imagePath, movie.imagePath)
        assertEquals(movies.title, movie.title)
    }

    @Test
    fun getSeries() {
        `when`(movieRepo.getAllSeries()).thenReturn(MoviesData.generateSerries() as ArrayList<Movies>)
        viewModel.setSelectedMovie(series.moviesId)
        val seriess = viewModel.getMovie()
        verify(movieRepo).getAllSeries()
        assertNotNull(series)
        assertEquals(series.moviesId, seriess.moviesId)
        assertEquals(series.genre, seriess.genre)
        assertEquals(series.sinopsis, seriess.sinopsis)
        assertEquals(series.imagePath, seriess.imagePath)
        assertEquals(series.title, seriess.title)
    }

}