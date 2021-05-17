package com.project.movie_jetpack.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
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

    override fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>> {

        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {

            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
            }
//                    localDataSource.getAllMovie()

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
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
        return localDataSource.getMovie(movieId)
    }

    override fun getAllSeries(): LiveData<Resource<PagedList<SeriesEntity>>> {

        return object : NetworkBoundResource<PagedList<SeriesEntity>, List<SeriesResponse>>(appExecutors) {

            public override fun loadFromDB(): LiveData<PagedList<SeriesEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllSeries(), config).build()
            }

            override fun shouldFetch(data: PagedList<SeriesEntity>?): Boolean =
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
        return localDataSource.getSeries(seriesId)
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) {
        localDataSource.setMovieFavorite(movie, state)
    }

    override fun getFavoriteSeries(): LiveData<PagedList<SeriesEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteSeries(), config).build()
    }

    override fun setSeriesFavorite(series: SeriesEntity, state: Boolean) {
        localDataSource.setSeriesFavorite(series, state)
    }
}