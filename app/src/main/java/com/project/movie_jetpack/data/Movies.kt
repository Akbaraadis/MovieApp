package com.project.movie_jetpack.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
        var moviesId: String,
        var title: String,
        var release: String,
        var sinopsis: String,
        var genre: String,
        var imagePath: String
):Parcelable