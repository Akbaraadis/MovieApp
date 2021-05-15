package com.project.movie_jetpack.ui.home.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.vo.Resource

class MovieViewModel (private val movieRepo: MovieRepo) : ViewModel() {

    fun getMovie(): LiveData<Resource<List<MovieEntity>>> = movieRepo.getAllMovie()

}