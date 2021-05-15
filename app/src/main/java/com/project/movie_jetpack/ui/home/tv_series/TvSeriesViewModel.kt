package com.project.movie_jetpack.ui.home.tv_series

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import com.project.movie_jetpack.data.vo.Resource

class TvSeriesViewModel (private val movieRepo: MovieRepo) : ViewModel() {

    fun getSeries(): LiveData<Resource<List<SeriesEntity>>> = movieRepo.getAllSeries()

}