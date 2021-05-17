package com.project.movie_jetpack.ui.favorite.favseries

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavSeriesViewModelTest {

    private lateinit var viewModel: FavSeriesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepo: MovieRepo

    @Mock
    private lateinit var observer: Observer<PagedList<SeriesEntity>>

    @Mock
    private lateinit var pagedList: PagedList<SeriesEntity>

    @Before
    fun setUp() {
        viewModel = FavSeriesViewModel(movieRepo)
    }

    @Test
    fun getMovie() {
        val dataMovie = pagedList
        Mockito.`when`(dataMovie.size).thenReturn(1)
        val movies = MutableLiveData<PagedList<SeriesEntity>>()
        movies.value = dataMovie

        Mockito.`when`(movieRepo.getFavoriteSeries()).thenReturn(movies)
        val courseEntities = viewModel.getFavoriteSeries().value
        Mockito.verify(movieRepo).getFavoriteSeries()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(1, courseEntities?.size)

        viewModel.getFavoriteSeries().observeForever(observer)
        Mockito.verify(observer).onChanged(dataMovie)
    }

}