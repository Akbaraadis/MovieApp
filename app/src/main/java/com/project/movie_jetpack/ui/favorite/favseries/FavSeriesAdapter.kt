package com.project.movie_jetpack.ui.favorite.favseries

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import com.project.movie_jetpack.databinding.ItemRowListBinding
import com.project.movie_jetpack.ui.detail.DetailMovieActivity

class FavSeriesAdapter: RecyclerView.Adapter<FavSeriesAdapter.SeriesViewHolder>() {

    private var listmovies = ArrayList<SeriesEntity>()

    fun setseries(series: List<SeriesEntity>) {
        if (series == null) return
        this.listmovies.clear()
        this.listmovies.addAll(series)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val itemsMovieBinding =
            ItemRowListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeriesViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val movies = listmovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listmovies.size

    class SeriesViewHolder(private val binding: ItemRowListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: SeriesEntity) {
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