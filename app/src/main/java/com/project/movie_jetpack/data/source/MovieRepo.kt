package com.project.movie_jetpack.data.source

import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.remote.RemoteDataSource

class MovieRepo private constructor(private val remoteDataSource: RemoteDataSource) : MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepo? = null
        fun getInstance(remoteData: RemoteDataSource): MovieRepo =
                instance ?: synchronized(this) {
                    instance ?: MovieRepo(remoteData).apply { instance = this }
                }
    }

    override fun getAllMovie(): List<Movies> {
        val movieResponse = remoteDataSource.getAllMovie()
        val movieList = ArrayList<Movies>()
        for (response in movieResponse) {
            val course = Movies(response.id,
                    response.title,
                    response.release_date,
                    response.overview,
                    response.imagePath)
            movieList.add(course)
        }
        return movieList
    }

    override fun getAllSeries(): List<Movies> {
        val seriesResponse = remoteDataSource.getAllSeries()
        val seriesList = ArrayList<Movies>()
        for (response in seriesResponse) {
            val course = Movies(response.id,
                    response.title,
                    response.release_date,
                    response.overview,
                    response.imagePath)
            seriesList.add(course)
        }
        return seriesList    }
}