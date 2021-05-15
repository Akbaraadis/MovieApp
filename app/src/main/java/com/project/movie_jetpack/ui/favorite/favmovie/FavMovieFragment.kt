package com.project.movie_jetpack.ui.favorite.favmovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.viewmodel.ViewModelFactory
import com.project.movie_jetpack.databinding.FragmentFavmovieBinding

class FavMovieFragment: Fragment(R.layout.fragment_favmovie) {

    private lateinit var _binding : FragmentFavmovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavmovieBinding.inflate(layoutInflater, container, false)
        return _binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        if (activity != null) {
//
//            val factory = ViewModelFactory.getInstance(requireActivity())
//            val viewModel = ViewModelProvider(this, factory)[FavMovieViewModel::class.java]
//
//            val movieAdapter = FavMovieAdapter()
//            _binding.progressBar.visibility = View.VISIBLE
//            viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { movie ->
//                _binding.progressBar.visibility = View.GONE
//                movieAdapter.setmovies(movie)
//                movieAdapter.notifyDataSetChanged()
//            })
//
//            with(_binding.movieRvList) {
//                layoutManager = LinearLayoutManager(context)
//                setHasFixedSize(true)
//                adapter = movieAdapter
//            }
//        }
//        else{
//            _binding.apply {
//                ivFavmovKosong.visibility = View.VISIBLE
//                tvFavmovKosong.visibility = View.VISIBLE
//            }
//        }
//    }
}