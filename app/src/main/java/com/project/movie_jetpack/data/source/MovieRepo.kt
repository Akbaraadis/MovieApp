package com.project.movie_jetpack.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.project.movie_jetpack.data.source.local.LocalDataSource
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import com.project.movie_jetpack.data.source.remote.ApiResponse
import com.project.movie_jetpack.data.source.remote.RemoteDataSource
import com.project.movie_jetpack.data.source.remote.response.MovieResponse
import com.project.movie_jetpack.data.source.remote.response.SeriesResponse
import com.project.movie_jetpack.data.utils.AppExecutors
import com.project.movie_jetpack.data.vo.Resource

class MovieRepo private constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors
        ) : MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepo? = null
        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): MovieRepo =
            instance ?: synchronized(this) {
                instance ?: MovieRepo(remoteData, localData, appExecutors).apply { instance = this }
            }
    }

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
//                    localDataSource.getAllSeries()

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

//    override fun getAllSeries(): LiveData<Resource<PagedList<SeriesEntity>>> {
//
//        return object : NetworkBoundResource<PagedList<SeriesEntity>, PagedList<SeriesResponse>>(appExecutors) {
//
//            public override fun loadFromDB(): LiveData<PagedList<SeriesEntity>> {
//                val config = PagedList.Config.Builder()
//                    .setEnablePlaceholders(false)
//                    .setInitialLoadSizeHint(4)
//                    .setPageSize(4)
//                    .build()
//                return LivePagedListBuilder(localDataSource.getAllSeries(), config).build()
//            }
////                    localDataSource.getAllSeries()
//
//            override fun shouldFetch(data: PagedList<SeriesEntity>?): Boolean =
//                    data == null || data.isEmpty()
//
//            public override fun createCall(): LiveData<ApiResponse<List<SeriesResponse>>> =
//                    remoteDataSource.getAllSeries()
//
//            public override fun saveCallResult(data: PagedList<SeriesResponse>) {
//                val seriesList = ArrayList<SeriesEntity>()
//                for (response in data) {
//                    val series = SeriesEntity(
//                            response.id,
//                            response.title,
//                            response.release_date,
//                            response.overview,
//                            response.genre,
//                            response.imagePath,
//                            false
//                    )
//                    seriesList.add(series)
//                }
//                localDataSource.insertSeries(seriesList)
//            }
//        }.asLiveData()
//    }

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

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }
//        localDataSource.getFavoriteMovie()

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state)
    }

    override fun getFavoriteSeries(): LiveData<PagedList<SeriesEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteSeries(), config).build()
    }
//        localDataSource.getFavoriteSeries()

    override fun setSeriesFavorite(series: SeriesEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setSeriesFavorite(series, state)
    }
}