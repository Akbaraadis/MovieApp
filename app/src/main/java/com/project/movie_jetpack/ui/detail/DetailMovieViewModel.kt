package com.project.movie_jetpack.ui.detail

import androidx.lifecycle.ViewModel
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.utils.MoviesData

class DetailMovieViewModel : ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }


    fun getMovie(): Movies {
        lateinit var movie: Movies
        val movieEntity = MoviesData.generateMovies()
        for (list_movie in movieEntity) {
            if (list_movie.moviesId == movieId) {
                movie = list_movie
            }
        }

        val seriesEntity = MoviesData.generateSerries()
        for (list_movie in seriesEntity) {
            if (list_movie.moviesId == movieId) {
                movie = list_movie
            }
        }
        return movie
    }


}