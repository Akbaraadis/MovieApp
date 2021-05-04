package com.project.movie_jetpack.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
        var moviesId: String,
        var title: String,
        var genre: String,
        var sinopsis: String,
        var imagePath: String
):Parcelable