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
class DetailViewModelTest{

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
        viewModel.setSelectedSeries(seriesId)
    }

    @Test
    fun getMovie() {
        val film = MutableLiveData<Movies>()
        film.value = movies

        `when`(movieRepo.getMovie(movieId)).thenReturn(film)
        val Entity = viewModel.getMovie().value as Movies
        verify(movieRepo).getMovie(movieId)
        assertNotNull(Entity)
        assertEquals(movies.moviesId, Entity.moviesId)
        assertEquals(movies.title, Entity.title)
        assertEquals(movies.release, Entity.release)
        assertEquals(movies.sinopsis, Entity.sinopsis)
        assertEquals(movies.genre, Entity.genre)
        assertEquals(movies.imagePath, Entity.imagePath)

        viewModel.getMovie().observeForever(Observer)
        verify(Observer).onChanged(movies)
    }

    @Test
    fun getSeries() {
        val film = MutableLiveData<Movies>()
        film.value = series

        `when`(movieRepo.getSeries(seriesId)).thenReturn(film)
        val Entity = viewModel.getSeries().value as Movies
        verify(movieRepo).getSeries(seriesId)
        assertNotNull(Entity)
        assertEquals(series.moviesId, Entity.moviesId)
        assertEquals(series.title, Entity.title)
        assertEquals(series.release, Entity.release)
        assertEquals(series.sinopsis, Entity.sinopsis)
        assertEquals(series.genre, Entity.genre)
        assertEquals(series.imagePath, Entity.imagePath)

        viewModel.getSeries().observeForever(Observer)
        verify(Observer).onChanged(movies)
    }

//    @Test
//    fun getMovie() {
//        val movie = MutableLiveData<List<Movies>>()
//        movie.value = movies
//
//        `when`(movieRepo.getAllMovie()).thenReturn(movie)
//        viewModel.setSelectedMovie(movies.moviesId)
//        val movie = viewModel.getMovie().value as Movies
//        verify(movieRepo).getAllMovie()
//        assertNotNull(movie)
//        assertEquals(movies.moviesId, movie.moviesId)
//        assertEquals(movies.genre, movie.genre)
//        assertEquals(movies.sinopsis, movie.sinopsis)
//        assertEquals(movies.imagePath, movie.imagePath)
//        assertEquals(movies.title, movie.title)
//
//        viewModel.getMovie().observeForever(Observer)
//        verify(Observer).onChanged(movies)
//    }

}