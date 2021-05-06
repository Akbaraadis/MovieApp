package com.project.movie_jetpack.data.di

import android.content.Context
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.source.remote.RemoteDataSource
import com.project.movie_jetpack.data.utils.JsonHelper

object DiModule {

    fun provideRepository(context: Context): MovieRepo {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieRepo.getInstance(remoteDataSource)
    }
}