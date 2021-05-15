package com.project.movie_jetpack.ui.favorite.favseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity

class FavSeriesViewModel (private val movieRepo: MovieRepo) : ViewModel(){

    fun getFavoriteMovie(): LiveData<List<SeriesEntity>> = movieRepo.getFavoriteSeries()

}