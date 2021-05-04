package com.project.movie_jetpack.data.source

import com.project.movie_jetpack.data.Movies

interface MovieDataSource {

    fun getAllMovie(): List<Movies>

    fun getAllSeries(): List<Movies>
}