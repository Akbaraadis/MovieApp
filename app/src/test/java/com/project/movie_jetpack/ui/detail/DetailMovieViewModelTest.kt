package com.project.movie_jetpack.ui.detail

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
class DetailMovieViewModelTest{

    private lateinit var viewModel: DetailViewModel
    private val movies = MoviesData.generateMovies()[0]
    private val movieId = movies.moviesId

    private val series = MoviesData.generateSerries()[0]
    private val seriesId = series.moviesId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepo: MovieRepo

    @Mock
    private lateinit var Observer: Observer<Movies>

    @Before
    fun setUpMovie() {
        viewModel = DetailViewModel(movieRepo)
        viewModel.setSelectedMovie(movieId)
    }

    @Before
    fun setUpSeries() {
        viewModel = DetailViewModel(movieRepo)
        viewModel.setSelectedMovie(seriesId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<Movies>()
        movie.value = movies

        `when`(movieRepo.getAllMovie()).thenReturn(movie)
        viewModel.setSelectedMovie(movies.moviesId)
        val movie = viewModel.getMovie().value as Movies
        verify(movieRepo).getAllMovie()
        assertNotNull(movie)
        assertEquals(movies.moviesId, movie.moviesId)
        assertEquals(movies.genre, movie.genre)
        assertEquals(movies.sinopsis, movie.sinopsis)
        assertEquals(movies.imagePath, movie.imagePath)
        assertEquals(movies.title, movie.title)

        viewModel.getMovie().observeForever(Observer)
        verify(Observer).onChanged(movies)
    }

    @Test
    fun getSeries() {
        val serie = MutableLiveData<Movies>()
        serie.value = series

        `when`(movieRepo.getAllSeries()).thenReturn(series)
        viewModel.setSelectedSeries(series.moviesId)
        val seriess = viewModel.getSeries().value as Movies
        verify(movieRepo).getAllSeries()
        assertNotNull(series)
        assertEquals(series.moviesId, seriess.moviesId)
        assertEquals(series.genre, seriess.genre)
        assertEquals(series.sinopsis, seriess.sinopsis)
        assertEquals(series.imagePath, seriess.imagePath)
        assertEquals(series.title, seriess.title)

        viewModel.getSeries().observeForever(Observer)
        verify(Observer).onChanged(series)
    }

}