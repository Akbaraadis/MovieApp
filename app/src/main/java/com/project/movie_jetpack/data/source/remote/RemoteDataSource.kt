package com.project.movie_jetpack.data.source.remote

import android.os.Handler
import android.os.Looper
import com.project.movie_jetpack.data.source.remote.response.MovieResponse
import com.project.movie_jetpack.data.source.remote.response.SeriesResponse
import com.project.movie_jetpack.data.utils.EspressoIdlingResource
import com.project.movie_jetpack.data.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(helper).apply { instance = this }
                }
    }

    fun getAllMovie(callback: LoadMovieCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMovieReceived(jsonHelper.loadMovie())
            EspressoIdlingResource.decrement() }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getAllSeries(callback: LoadSeriesCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllSeriesReceived(jsonHelper.loadSeries())
            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMovieCallback {
        fun onAllMovieReceived(movieResponses: List<MovieResponse>)
    }

    interface LoadSeriesCallback {
        fun onAllSeriesReceived(seriesResponses: List<SeriesResponse>)
    }

}