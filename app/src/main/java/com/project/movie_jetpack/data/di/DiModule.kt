package com.project.movie_jetpack.data.di

import android.content.Context
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.source.local.LocalDataSource
import com.project.movie_jetpack.data.source.local.room.MovieDatabase
import com.project.movie_jetpack.data.source.remote.RemoteDataSource
import com.project.movie_jetpack.data.utils.AppExecutors
import com.project.movie_jetpack.data.utils.JsonHelper

object DiModule {

    fun provideRepository(context: Context): MovieRepo {

        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return MovieRepo.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}