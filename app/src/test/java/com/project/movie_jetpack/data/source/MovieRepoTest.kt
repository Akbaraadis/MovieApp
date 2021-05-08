package com.project.movie_jetpack.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer
import com.project.movie_jetpack.data.FakeMovieRepo
import com.project.movie_jetpack.data.source.remote.RemoteDataSource
import com.project.movie_jetpack.data.utils.LiveDataTestUtil
import com.project.movie_jetpack.data.utils.MoviesData
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito


class MovieRepoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieRepo = FakeMovieRepo(remote)

    private val movieResponse = MoviesData.generateRemoteMovie()
    private val seriesResponse = MoviesData.generateRemoteSeries()

    @Test
    fun getAllMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                    .onAllMovieReceived(movieResponse)
            null
        }.`when`(remote).getAllMovie(any())
        val movie = LiveDataTestUtil.getValue(movieRepo.getAllMovie())
        verify(remote).getAllMovie(any())
        assertNotNull(movie)
        assertEquals(movieResponse.size.toLong(), movie.size.toLong())
    }

    @Test
    fun getAllSeries() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadSeriesCallback)
                    .onAllSeriesReceived(seriesResponse)
            null
        }.`when`(remote).getAllSeries(any())
        val series = LiveDataTestUtil.getValue(movieRepo.getAllSeries())
        verify(remote).getAllSeries(any())
        assertNotNull(series)
        assertEquals(seriesResponse.size.toLong(), series.size.toLong())
    }
}