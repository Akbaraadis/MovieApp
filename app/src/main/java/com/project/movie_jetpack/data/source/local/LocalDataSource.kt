package com.project.movie_jetpack.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import com.project.movie_jetpack.data.source.local.room.MovieDAO

class LocalDataSource private constructor(private val mMovieDao: MovieDAO) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDAO): LocalDataSource =
                INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getAllMovie(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getAllMovies()

    fun getMovie(movieId: String): LiveData<MovieEntity> =
            mMovieDao.getMovies(movieId)

    fun getAllSeries(): DataSource.Factory<Int, SeriesEntity> = mMovieDao.getAllSeriess()

    fun getSeries(seriesId: String): LiveData<SeriesEntity> =
            mMovieDao.getSeries(seriesId)

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavoriteMovies()

    fun getFavoriteSeries(): DataSource.Factory<Int, SeriesEntity> = mMovieDao.getFavoriteSeries()


    fun insertMovie(movie: ArrayList<MovieEntity>) = mMovieDao.insertMovies(movie)

    fun insertSeries(movie: ArrayList<SeriesEntity>) = mMovieDao.insertSeries(movie)


    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        mMovieDao.updateMovie(movie)
    }

    fun setSeriesFavorite(series: SeriesEntity, newState: Boolean) {
        series.favorite = newState
        mMovieDao.updateSeries(series)
    }
}