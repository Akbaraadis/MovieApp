package com.project.movie_jetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity

class DetailViewModel (private val movieRepo: MovieRepo) : ViewModel() {

    private lateinit var movieId: String
    private lateinit var seriesId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun setSelectedSeries(seriesId: String){
        this.seriesId = seriesId
    }

    fun getMovie(): LiveData<MovieEntity> = movieRepo.getMovie(movieId)

    fun getSeries(): LiveData<SeriesEntity> = movieRepo.getSeries(seriesId)

    fun addMovieFavorite(movie: MovieEntity) = movieRepo.setMovieFavorite(movie, true)

    fun removeMovieFavorite(movie: MovieEntity) = movieRepo.setMovieFavorite(movie, false)

    fun addSeriesFavorite(series: SeriesEntity) = movieRepo.setSeriesFavorite(series, true)

    fun removeSeriesFavorite(series: SeriesEntity) = movieRepo.setSeriesFavorite(series, false)

}