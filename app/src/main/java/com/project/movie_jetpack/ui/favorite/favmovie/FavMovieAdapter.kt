package com.project.movie_jetpack.ui.favorite.favmovie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.databinding.ItemRowListBinding
import com.project.movie_jetpack.ui.detail.DetailMovieActivity
import com.project.movie_jetpack.ui.home.movie.MovieAdapter

class FavMovieAdapter: PagedListAdapter<MovieEntity, FavMovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding =
            ItemRowListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null){
            holder.bind(movies)
        }
    }

    fun getSwipedData(swipedPosition: Int): MovieEntity? = getItem(swipedPosition)

    inner class MovieViewHolder(private val binding: ItemRowListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MovieEntity) {
            with(binding) {
                tvItemName.text = movies.title
                tvItemGenre.text = movies.genre
                tvItemRelease.text = movies.release
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.movieId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movies.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                            .error(R.drawable.ic_baseline_error_24)
                    )
                    .into(imgItemPhoto)
            }
        }
    }
}