package com.project.movie_jetpack.ui.favorite.favmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.source.local.entity.MovieEntity

class FavMovieViewModel (private val movieRepo: MovieRepo) : ViewModel() {

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> = movieRepo.getFavoriteMovie()

    fun swipeFavorite(movieEntity: MovieEntity) {
        val newState = !movieEntity.favorite
        movieRepo.setMovieFavorite(movieEntity, newState)
    }
}