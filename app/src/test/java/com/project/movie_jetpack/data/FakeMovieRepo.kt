package com.project.movie_jetpack.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.MovieDataSource
import com.project.movie_jetpack.data.source.NetworkBoundResource
import com.project.movie_jetpack.data.source.local.LocalDataSource
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import com.project.movie_jetpack.data.source.remote.ApiResponse
import com.project.movie_jetpack.data.source.remote.RemoteDataSource
import com.project.movie_jetpack.data.source.remote.response.MovieResponse
import com.project.movie_jetpack.data.source.remote.response.SeriesResponse
import com.project.movie_jetpack.data.utils.AppExecutors
import com.project.movie_jetpack.data.vo.Resource

class FakeMovieRepo constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors) : MovieDataSource {

    override fun getAllMovie(): LiveData<Resource<List<MovieEntity>>> {

        return object : NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutors) {

            public override fun loadFromDB(): LiveData<List<MovieEntity>> =
                    localDataSource.getAllMovie()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                    data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                    remoteDataSource.getAllMovie()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                            response.id,
                            response.title,
                            response.release_date,
                            response.overview,
                            response.genre,
                            response.imagePath,
                            false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getMovie(movieId: String): LiveData<MovieEntity> {

//        val movieResult = MutableLiveData<Movies>()

//        localDataSource.getMovie(movieId)

//        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMovieCallback {
//            override fun onAllMovieReceived(movieResponses: List<MovieResponse>) {
//                lateinit var movie: Movies
//                for (response in movieResponses) {
//                    if (response.id == movieId) {
//                        movie = Movies(
//                                response.id,
//                                response.title,
//                                response.release_date,
//                                response.overview,
//                                response.genre,
//                                response.imagePath
//                        )
//                    }
//                }
//                movieResult.postValue(movie)
//            }
//        })
        return localDataSource.getMovie(movieId)
    }

    override fun getAllSeries(): LiveData<Resource<List<SeriesEntity>>> {

        return object : NetworkBoundResource<List<SeriesEntity>, List<SeriesResponse>>(appExecutors) {

            public override fun loadFromDB(): LiveData<List<SeriesEntity>> =
                    localDataSource.getAllSeries()

            override fun shouldFetch(data: List<SeriesEntity>?): Boolean =
                    data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<SeriesResponse>>> =
                    remoteDataSource.getAllSeries()

            public override fun saveCallResult(data: List<SeriesResponse>) {
                val seriesList = ArrayList<SeriesEntity>()
                for (response in data) {
                    val series = SeriesEntity(
                            response.id,
                            response.title,
                            response.release_date,
                            response.overview,
                            response.genre,
                            response.imagePath,
                            false
                    )
                    seriesList.add(series)
                }
                localDataSource.insertSeries(seriesList)
            }
        }.asLiveData()
    }

    override fun getSeries(seriesId: String): LiveData<SeriesEntity> {

//        val seriesResult = MutableLiveData<Movies>()
//
//        remoteDataSource.getAllSeries(object : RemoteDataSource.LoadSeriesCallback {
//            override fun onAllSeriesReceived(seriesResponses: List<SeriesResponse>) {
//                lateinit var series: Movies
//                for (response in seriesResponses) {
//                    if (response.id == seriesId) {
//                        series = Movies(
//                            response.id,
//                            response.title,
//                            response.release_date,
//                            response.overview,
//                            response.genre,
//                            response.imagePath
//                        )
//                    }
//                }
//                seriesResult.postValue(series)
//            }
//        })
        return localDataSource.getSeries(seriesId)
    }

    override fun getFavoriteMovie(): LiveData<List<MovieEntity>> =
            localDataSource.getFavoriteMovie()

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
            appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state)
            }

    override fun getFavoriteSeries(): LiveData<List<SeriesEntity>> =
            localDataSource.getFavoriteSeries()

    override fun setSeriesFavorite(series: SeriesEntity, state: Boolean) =
            appExecutors.diskIO().execute { localDataSource.setSeriesFavorite(series, state)
            }
}