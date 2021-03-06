package com.project.movie_jetpack.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
        var id: String,
        var title: String,
        var release_date: String,
        var overview: String,
        var genre: String,
        var imagePath: String
): Parcelable
