package com.project.movie_jetpack.ui.home.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.MovieRepo

class MovieViewModel (private val movieRepo: MovieRepo) : ViewModel() {

    fun getMovie(): List<Movies> = movieRepo.getAllMovie()

}