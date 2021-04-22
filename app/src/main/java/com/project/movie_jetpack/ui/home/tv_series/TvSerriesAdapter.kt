package com.project.movie_jetpack.ui.home.tv_series

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.databinding.ItemRowListBinding
import com.project.movie_jetpack.ui.detail.DetailMovieActivity

class TvSerriesAdapter : RecyclerView.Adapter<TvSerriesAdapter.MovieViewHolder>() {

    private var listmovies = ArrayList<Movies>()

    fun setmovies(movies: List<Movies>?) {
        if (movies == null) return
        this.listmovies.clear()
        this.listmovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding = ItemRowListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = listmovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listmovies.size

    class MovieViewHolder(private val binding: ItemRowListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: Movies) {
            with(binding) {
                tvItemName.text = movies.title
                tvItemGenre.text = movies.genre
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.moviesId)
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