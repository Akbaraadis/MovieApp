package com.project.movie_jetpack.ui.home.tv_series

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import com.project.movie_jetpack.databinding.ItemRowListBinding
import com.project.movie_jetpack.ui.detail.DetailSeriesActivity
import com.project.movie_jetpack.ui.home.movie.MovieAdapter

class TvSeriesAdapter : PagedListAdapter<SeriesEntity, TvSeriesAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SeriesEntity>() {
            override fun areItemsTheSame(oldItem: SeriesEntity, newItem: SeriesEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }
            override fun areContentsTheSame(oldItem: SeriesEntity, newItem: SeriesEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding = ItemRowListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null){
            holder.bind(movies)
        }
    }

    class MovieViewHolder(private val binding: ItemRowListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: SeriesEntity) {
            with(binding) {
                tvItemName.text = movies.title
                tvItemGenre.text = movies.genre
                tvItemRelease.text = movies.release
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailSeriesActivity::class.java)
                    intent.putExtra(DetailSeriesActivity.EXTRA_SERIES, movies.movieId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(movies.imagePath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                                .error(R.drawable.ic_baseline_error_24))
                        .into(imgItemPhoto)
            }
        }
    }
}