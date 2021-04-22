package com.project.movie_jetpack.ui.detail

import com.project.movie_jetpack.data.utils.MoviesData
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest{

    private lateinit var viewModel: DetailMovieViewModel
    private val movies = MoviesData.generateMovies()[0]
    private val movieId = movies.moviesId

    private val series = MoviesData.generateSerries()[0]
    private val seriesId = series.moviesId

    @Before
    fun setUpMovie() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Before
    fun setUpSeries() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(seriesId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(movies.moviesId)
        val movie = viewModel.getMovie()
        assertNotNull(movie)
        assertEquals(movies.moviesId, movie.moviesId)
        assertEquals(movies.genre, movie.genre)
        assertEquals(movies.sinopsis, movie.sinopsis)
        assertEquals(movies.imagePath, movie.imagePath)
        assertEquals(movies.title, movie.title)
    }

    @Test
    fun getSeries() {
        viewModel.setSelectedMovie(series.moviesId)
        val seriess = viewModel.getMovie()
        assertNotNull(series)
        assertEquals(series.moviesId, seriess.moviesId)
        assertEquals(series.genre, seriess.genre)
        assertEquals(series.sinopsis, seriess.sinopsis)
        assertEquals(series.imagePath, seriess.imagePath)
        assertEquals(series.title, seriess.title)
    }

}