package com.project.movie_jetpack.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity

@Database(entities = [MovieEntity::class, SeriesEntity::class],
        version = 1,
        exportSchema = false)

abstract class MovieDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDAO

    companion object {

        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase =
                INSTANCE ?: synchronized(this) {
                    Room.databaseBuilder(
                            context.applicationContext,
                            MovieDatabase::class.java,
                            "Movie.db"
                    ).build().apply {
                        INSTANCE = this
                    }
                }
    }
}