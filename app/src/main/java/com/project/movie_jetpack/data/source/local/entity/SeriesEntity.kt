package com.project.movie_jetpack.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "seriesentities")
data class SeriesEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "movieId")
        var movieId: String,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "release")
        var release: String,

        @ColumnInfo(name = "sinopsis")
        var sinopsis: String,

        @ColumnInfo(name = "genre")
        var genre: String,

        @ColumnInfo(name = "imagePath")
        var imagePath: String,

        @ColumnInfo(name = "favorite")
        var favorite: Boolean = false,
)
