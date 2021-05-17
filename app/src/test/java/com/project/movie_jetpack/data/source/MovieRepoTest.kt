package com.project.movie_jetpack.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.verify
import com.project.movie_jetpack.data.FakeMovieRepo
import com.project.movie_jetpack.data.source.local.LocalDataSource
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import com.project.movie_jetpack.data.source.remote.RemoteDataSource
import com.project.movie_jetpack.data.utils.AppExecutors
import com.project.movie_jetpack.data.utils.LiveDataTestUtil
import com.project.movie_jetpack.data.utils.MoviesData
import com.project.movie_jetpack.data.vo.Resource
import com.project.movie_jetpack.utils.PagedListUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*


class MovieRepoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val movieRepo = FakeMovieRepo(remote, local, appExecutors)

    private val movieResponse = MoviesData.generateRemoteMovie()
    private val seriesResponse = MoviesData.generateRemoteSeries()

    @Test
    fun getAllMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        movieRepo.getAllMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(MoviesData.generateMovies()))
        verify(local).getAllMovie()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllSeries() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, SeriesEntity>
        `when`(local.getAllSeries()).thenReturn(dataSourceFactory)
        movieRepo.getAllSeries()

        val seriesEntities = Resource.success(PagedListUtil.mockPagedList(MoviesData.generateSerries()))
        verify(local).getAllSeries()
        assertNotNull(seriesEntities.data)
        assertEquals(seriesResponse.size.toLong(), seriesEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        movieRepo.getFavoriteMovie()
        val movieEntities = Resource.success(PagedListUtil.mockPagedList(MoviesData.generateMovies()))
        verify(local).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteSeries() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, SeriesEntity>
        `when`(local.getFavoriteSeries()).thenReturn(dataSourceFactory)
        movieRepo.getFavoriteSeries()
        val seriesEntities = Resource.success(PagedListUtil.mockPagedList(MoviesData.generateSerries()))
        verify(local).getFavoriteSeries()
        assertNotNull(seriesEntities)
        assertEquals(seriesResponse.size.toLong(), seriesEntities.data?.size?.toLong())
    }

    @Test
    fun setFavoriteMovie() {
        movieRepo.setMovieFavorite(MoviesData.getFavMovie(), true)
        verify(local).setMovieFavorite(MoviesData.getFavMovie(), true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun setFavoriteSeries(){
        movieRepo.setSeriesFavorite(MoviesData.getFavSeries(), true)
        verify(local).setSeriesFavorite(MoviesData.getFavSeries(), true)
        verifyNoMoreInteractions(local)
    }
}