package com.project.movie_jetpack.data.source

import androidx.lifecycle.LiveData
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import com.project.movie_jetpack.data.vo.Resource

interface MovieDataSource {

    fun getAllMovie(): LiveData<Resource<List<MovieEntity>>>

    fun getMovie(movieId: String): LiveData<MovieEntity>

    fun getAllSeries(): LiveData<Resource<List<SeriesEntity>>>

    fun getSeries(movieId: String): LiveData<SeriesEntity>

    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    fun getFavoriteSeries(): LiveData<List<SeriesEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun setSeriesFavorite(series: SeriesEntity, state: Boolean)
}