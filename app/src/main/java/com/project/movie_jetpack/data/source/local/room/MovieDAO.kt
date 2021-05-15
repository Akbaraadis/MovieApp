package com.project.movie_jetpack.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity

@Dao
interface MovieDAO {
    @Query("SELECT * FROM movieentities")
    fun getAllMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieentities where movieId = :movie")
    fun getMovies(movie: String): LiveData<MovieEntity>

    @Query("SELECT * FROM seriesentities")
    fun getAllSeriess(): LiveData<List<SeriesEntity>>

    @Query("SELECT * FROM seriesentities where movieId = :series")
    fun getSeries(series: String): LiveData<SeriesEntity>

    @Query("SELECT * FROM movieentities where favorite = 1")
    fun getFavoriteMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM seriesentities where favorite = 1")
    fun getFavoriteSeries(): LiveData<List<SeriesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie: ArrayList<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSeries(series: ArrayList<SeriesEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateSeries(series: SeriesEntity)
}