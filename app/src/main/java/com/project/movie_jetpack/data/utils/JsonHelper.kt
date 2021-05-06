package com.project.movie_jetpack.data.utils

import android.content.Context
import com.project.movie_jetpack.data.source.remote.response.MovieResponse
import com.project.movie_jetpack.data.source.remote.response.SeriesResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movie")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val release_date = movie.getString("release_date")
                val overview = movie.getString("overview")
                val genre = movie.getString("genre")
                val imagePath = movie.getString("imagePath")

                val movieResponse = MovieResponse(id, title, release_date, overview, genre, imagePath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadSeries(): List<SeriesResponse> {
        val list = ArrayList<SeriesResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("SeriesResponses.json").toString())
            val listArray = responseObject.getJSONArray("series")
            for (i in 0 until listArray.length()) {
                val series = listArray.getJSONObject(i)

                val id = series.getString("id")
                val title = series.getString("title")
                val release_date = series.getString("release_date")
                val overview = series.getString("overview")
                val genre = series.getString("genre")
                val imagePath = series.getString("imagePath")

                val SeriesResponse = SeriesResponse(id, title, release_date, overview, genre, imagePath)
                list.add(SeriesResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

}