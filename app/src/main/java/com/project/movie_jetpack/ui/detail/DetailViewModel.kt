package com.project.movie_jetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import com.project.movie_jetpack.data.vo.Resource

class DetailViewModel (private val movieRepo: MovieRepo) : ViewModel() {

    private lateinit var movieId: String
    private lateinit var seriesId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun setSelectedSeries(seriesId: String){
        this.seriesId = seriesId
    }

    fun getMovie(): LiveData<MovieEntity> = movieRepo.getMovie(movieId)

    fun getSeries(): LiveData<SeriesEntity> = movieRepo.getSeries(seriesId)

//    var courseModule: LiveData<Resource<CourseWithModule>> = Transformations.switchMap(courseId) { mCourseId ->
//        academyRepository.getCourseWithModules(mCourseId)
//    }
//
//    fun setBookmark() {
//        val moduleResource = courseModule.value
//        if (moduleResource != null) {
//            val courseWithModule = moduleResource.data
//            if (courseWithModule != null) {
//                val courseEntity = courseWithModule.mCourse
//                val newState = !courseEntity.bookmarked
//                academyRepository.setCourseBookmark(courseEntity, newState)
//            }
//        }
//    }

//    fun setFavoriteMovie(movieId: String){
//        val movieFavorite = LiveData<MovieEntity>
//        movieRepo.setMovieFavorite(movieId, true)
//    }

}