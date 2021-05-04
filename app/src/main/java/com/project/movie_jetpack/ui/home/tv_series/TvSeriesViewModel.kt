package com.project.movie_jetpack.ui.home.tv_series

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.MovieRepo

class TvSeriesViewModel (private val movieRepo: MovieRepo) : ViewModel() {

    fun getSerries(): LiveData<List<Movies>> = movieRepo.getAllSeries()

}