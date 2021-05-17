package com.project.movie_jetpack.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import com.project.movie_jetpack.data.vo.Resource

interface MovieDataSource {

    fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getMovie(movieId: String): LiveData<MovieEntity>

    fun getAllSeries(): LiveData<Resource<PagedList<SeriesEntity>>>

    fun getSeries(movieId: String): LiveData<SeriesEntity>

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteSeries(): LiveData<PagedList<SeriesEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun setSeriesFavorite(series: SeriesEntity, state: Boolean)
}