package com.project.movie_jetpack.ui.favorite.favmovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavMovieViewModelTest {

    private lateinit var viewModel: FavMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepo: MovieRepo

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavMovieViewModel(movieRepo)
    }

    @Test
    fun getMovie() {
        val dataMovie = pagedList
        `when`(dataMovie.size).thenReturn(1)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dataMovie

        `when`(movieRepo.getFavoriteMovie()).thenReturn(movies)
        val courseEntities = viewModel.getFavoriteMovie().value
        verify(movieRepo).getFavoriteMovie()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(1, courseEntities?.size)

        viewModel.getFavoriteMovie().observeForever(observer)
        verify(observer).onChanged(dataMovie)
    }

}