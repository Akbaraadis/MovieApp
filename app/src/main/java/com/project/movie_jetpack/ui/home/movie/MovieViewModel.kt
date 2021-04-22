package com.project.movie_jetpack.ui.home.movie

import androidx.lifecycle.ViewModel
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.utils.MoviesData

class MovieViewModel : ViewModel() {

    fun getMovie(): List<Movies> = MoviesData.generateMovies()

}