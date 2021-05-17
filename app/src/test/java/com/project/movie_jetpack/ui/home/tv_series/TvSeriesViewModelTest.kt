package com.project.movie_jetpack.ui.home.tv_series

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import com.project.movie_jetpack.data.utils.MoviesData
import com.project.movie_jetpack.data.vo.Resource
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
    private lateinit var observer: Observer<Resource<PagedList<SeriesEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<SeriesEntity>

    @Before
    fun setUp() {
        viewModel = TvSeriesViewModel(movieRepo)
    }

    @Test
    fun getSeries() {
        val dataMovie = Resource.success(pagedList)
        `when`(dataMovie.data?.size).thenReturn(10)
        val series = MutableLiveData<Resource<PagedList<SeriesEntity>>>()
        series.value = dataMovie

        `when`(movieRepo.getAllSeries()).thenReturn(series)
        val courseEntities = viewModel.getSeries().value?.data
        verify(movieRepo).getAllSeries()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities?.size)

        viewModel.getSeries().observeForever(observer)
        verify(observer).onChanged(dataMovie)
    }

}