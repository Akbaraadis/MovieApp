package com.project.movie_jetpack.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.viewmodel.ViewModelFactory
import com.project.movie_jetpack.data.vo.Status
import com.project.movie_jetpack.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    lateinit var Movie : MovieEntity

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var binding: ActivityDetailMovieBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]


        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {

                binding.progressBar.visibility = View.VISIBLE
                binding.detailContent.visibility = View.INVISIBLE

                viewModel.setSelectedMovie(movieId)

                viewModel.getMovie().observe(this, { movie ->

                    Movie = movie

                    binding.progressBar.visibility = View.GONE
                    binding.detailContent.visibility = View.VISIBLE
                    viewModel.setSelectedMovie(movie.movieId)
                    if(movie.favorite){
                        binding.detailIvFavBorder.visibility = View.GONE
                        binding.detailIvFav.visibility = View.VISIBLE
                    }
                    else{
                        binding.detailIvFavBorder.visibility = View.VISIBLE
                        binding.detailIvFav.visibility = View.GONE
                    }
                })
                viewModel.getMovie().observe(this, { movie -> showMovie(movie) })
            }
        }

        binding.detailIvFavBorder.setOnClickListener {
            viewModel.addMovieFavorite(Movie)
            Toast.makeText(this, "Movie Berhasil Ditambahkan Ke Favorite", Toast.LENGTH_SHORT).show()
        }

        binding.detailIvFav.setOnClickListener {
            viewModel.removeMovieFavorite(Movie)
            Toast.makeText(this, "Movie Berhasil Dihapus Dari Favorite", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showMovie(movie: MovieEntity) {
        binding.apply {
            detailTvTitle.text = movie.title
            detailTvGenre.text = movie.genre
            detailTvRelease.text = movie.release
            detailTvSinopsis.text = movie.sinopsis
        }

        Glide.with(this)
                .load(movie.imagePath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                        .error(R.drawable.ic_baseline_error_24))
                .into(binding.detailIvPoster)

        Glide.with(this)
            .load(movie.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                .error(R.drawable.ic_baseline_error_24))
            .into(binding.bgImage)

    }
}