package com.project.movie_jetpack.ui.home.tv_series

import androidx.lifecycle.ViewModel
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.utils.MoviesData

class TvSerriesViewModel : ViewModel() {

    fun getSerries(): List<Movies> = MoviesData.generateSerries()

}