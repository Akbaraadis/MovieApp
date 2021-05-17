package com.project.movie_jetpack.ui.favorite.favseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity

class FavSeriesViewModel (private val movieRepo: MovieRepo) : ViewModel(){

    fun getFavoriteSeries(): LiveData<PagedList<SeriesEntity>> = movieRepo.getFavoriteSeries()

    fun swipeFavorite(seriesEntity: SeriesEntity) {
        val newState = !seriesEntity.favorite
        movieRepo.setSeriesFavorite(seriesEntity, newState)
    }
}