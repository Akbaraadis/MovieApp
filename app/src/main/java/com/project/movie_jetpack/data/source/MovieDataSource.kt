package com.project.movie_jetpack.data.source

import androidx.lifecycle.LiveData
import com.project.movie_jetpack.data.Movies

interface MovieDataSource {

    fun getAllMovie(): LiveData<List<Movies>>

//    fun getMovie(movieId: String): LiveData<Movies>

    fun getAllSeries(): LiveData<List<Movies>>

//    fun getSeries(movieId: String): LiveData<Movies>
}