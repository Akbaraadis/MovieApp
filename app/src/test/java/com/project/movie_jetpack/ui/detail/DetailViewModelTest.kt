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
    private lateinit var viewModel1: DetailViewModel
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
        viewModel1 = DetailViewModel(movieRepo)
        viewModel1.setSelectedSeries(seriesId)
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
        val course = MutableLiveData<Movies>()
        course.value = series

        `when`(movieRepo.getSeries(seriesId)).thenReturn(course)
        val courseEntity = viewModel1.getSeries().value as Movies
        verify(movieRepo).getSeries(seriesId)
        assertNotNull(courseEntity)
        assertEquals(series.moviesId, courseEntity.moviesId)
        assertEquals(series.title, courseEntity.title)
        assertEquals(series.release, courseEntity.release)
        assertEquals(series.sinopsis, courseEntity.sinopsis)
        assertEquals(series.genre, courseEntity.genre)
        assertEquals(series.imagePath, courseEntity.imagePath)

        viewModel1.getSeries().observeForever(Observer)
        verify(Observer).onChanged(series)
    }

}