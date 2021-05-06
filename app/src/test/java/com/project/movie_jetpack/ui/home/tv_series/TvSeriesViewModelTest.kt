package com.project.movie_jetpack.ui.home.tv_series

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
class TvSeriesViewModelTest {

    private lateinit var viewModel: TvSeriesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepo: MovieRepo

    @Mock
    private lateinit var observer: Observer<List<Movies>>

    @Before
    fun setUp() {
        viewModel = TvSeriesViewModel(movieRepo)
    }

    @Test
    fun getSeries() {
        val dataMovie = MoviesData.generateSerries()
        val series = MutableLiveData<List<Movies>>()
        series.value = dataMovie

        `when`(movieRepo.getAllSeries()).thenReturn(series)
        val courseEntities = viewModel.getSeries().value
        verify(movieRepo).getAllSeries()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities?.size)

        viewModel.getSeries().observeForever(observer)
        verify(observer).onChanged(dataMovie)
    }

}