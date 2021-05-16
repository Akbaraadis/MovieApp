package com.project.movie_jetpack.data.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.movie_jetpack.data.di.DiModule
import com.project.movie_jetpack.data.source.MovieRepo
import com.project.movie_jetpack.ui.detail.DetailViewModel
import com.project.movie_jetpack.ui.favorite.favmovie.FavMovieViewModel
import com.project.movie_jetpack.ui.favorite.favseries.FavSeriesViewModel
import com.project.movie_jetpack.ui.home.movie.MovieViewModel
import com.project.movie_jetpack.ui.home.tv_series.TvSeriesViewModel

class ViewModelFactory private constructor(private val mMovieRepo: MovieRepo) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(DiModule.provideRepository(context)).apply {
                        instance = this
                    }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mMovieRepo) as T
            }
            modelClass.isAssignableFrom(TvSeriesViewModel::class.java) -> {
                return TvSeriesViewModel(mMovieRepo) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(mMovieRepo) as T
            }
            modelClass.isAssignableFrom(FavMovieViewModel::class.java) -> {
                return FavMovieViewModel(mMovieRepo) as T
            }
            modelClass.isAssignableFrom(FavSeriesViewModel::class.java) -> {
                return FavSeriesViewModel(mMovieRepo) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}