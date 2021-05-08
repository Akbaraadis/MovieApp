package com.project.movie_jetpack.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.MovieDataSource
import com.project.movie_jetpack.data.source.remote.RemoteDataSource
import com.project.movie_jetpack.data.source.remote.response.MovieResponse
import com.project.movie_jetpack.data.source.remote.response.SeriesResponse

class FakeMovieRepo (private val remoteDataSource: RemoteDataSource) : MovieDataSource {

    override fun getAllMovie(): LiveData<List<Movies>> {
        val movieResults = MutableLiveData<List<Movies>>()
        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movieResponses: List<MovieResponse>) {
                val movieList = ArrayList<Movies>()
                for (response in movieResponses) {
                    val movie = Movies(
                        response.id,
                        response.title,
                        response.release_date,
                        response.overview,
                        response.genre,
                        response.imagePath
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getMovie(movieId: String): LiveData<Movies> {

        val movieResult = MutableLiveData<Movies>()

        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movieResponses: List<MovieResponse>) {
                lateinit var movie: Movies
                for (response in movieResponses) {
                    if (response.id == movieId) {
                        movie = Movies(
                            response.id,
                            response.title,
                            response.release_date,
                            response.overview,
                            response.genre,
                            response.imagePath
                        )
                    }
                }
                movieResult.postValue(movie)
            }
        })
        return movieResult
    }

    override fun getAllSeries(): LiveData<List<Movies>> {
        val seriesResults = MutableLiveData<List<Movies>>()
        remoteDataSource.getAllSeries(object : RemoteDataSource.LoadSeriesCallback {
            override fun onAllSeriesReceived(seriesResponses: List<SeriesResponse>) {
                val seriesList = ArrayList<Movies>()
                for (response in seriesResponses) {
                    val series = Movies(
                        response.id,
                        response.title,
                        response.release_date,
                        response.overview,
                        response.genre,
                        response.imagePath
                    )
                    seriesList.add(series)
                }
                seriesResults.postValue(seriesList)
            }
        })
        return seriesResults
    }

    override fun getSeries(seriesId: String): LiveData<Movies> {

        val seriesResult = MutableLiveData<Movies>()

        remoteDataSource.getAllSeries(object : RemoteDataSource.LoadSeriesCallback {
            override fun onAllSeriesReceived(seriesResponses: List<SeriesResponse>) {
                lateinit var series: Movies
                for (response in seriesResponses) {
                    if (response.id == seriesId) {
                        series = Movies(
                            response.id,
                            response.title,
                            response.release_date,
                            response.overview,
                            response.genre,
                            response.imagePath
                        )
                    }
                }
                seriesResult.postValue(series)
            }
        })
        return seriesResult
    }
}