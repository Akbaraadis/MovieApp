package com.project.movie_jetpack.ui.home.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.viewmodel.ViewModelFactory
import com.project.movie_jetpack.databinding.FragmentMovieBinding

class MovieFragment: Fragment(R.layout.fragment_movie) {

    private lateinit var _binding : FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            val viewmovie = viewModel.getMovie()

            val movieAdapter = MovieAdapter()
            movieAdapter.setmovies(viewmovie)

            with(_binding.movieRvList) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}