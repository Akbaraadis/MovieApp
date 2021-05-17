package com.project.movie_jetpack.ui.favorite.favmovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.viewmodel.ViewModelFactory
import com.project.movie_jetpack.databinding.FragmentFavmovieBinding

class FavMovieFragment: Fragment(R.layout.fragment_favmovie) {

    private lateinit var _binding : FragmentFavmovieBinding
    private lateinit var viewModel: FavMovieViewModel
    private lateinit var movieAdapter: FavMovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavmovieBinding.inflate(layoutInflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(_binding?.movieRvList)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavMovieViewModel::class.java]

            movieAdapter = FavMovieAdapter()

            _binding.progressBar.visibility = View.VISIBLE
            viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { movie ->
                _binding.progressBar.visibility = View.GONE
                movieAdapter.submitList(movie)
            })

            with(_binding.movieRvList) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
        else{
            _binding.apply {
                ivFavmovKosong.visibility = View.VISIBLE
                tvFavmovKosong.visibility = View.VISIBLE
            }
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val courseEntity = movieAdapter.getSwipedData(swipedPosition)
                courseEntity?.let { viewModel.swipeFavorite(it) }
                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    courseEntity?.let { viewModel.swipeFavorite(it) }
                }
                snackbar.show()
            }
        }
    })
}