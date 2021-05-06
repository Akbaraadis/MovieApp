package com.project.movie_jetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.utils.MoviesData

class DetailViewModel (private val movieRepo: MovieRepo) : ViewModel() {

    private lateinit var movieId: String
    private lateinit var seriesId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun setSelectedSeries(seriesId: String){
        this.seriesId = seriesId
    }

    fun getMovie(): LiveData<Movies> = movieRepo.getMovie(movieId)

    fun getSeries(): LiveData<Movies> = movieRepo.getSeries(seriesId)

}