package com.project.movie_jetpack.ui.home.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.viewmodel.ViewModelFactory
import com.project.movie_jetpack.data.vo.Status
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

            val movieAdapter = MovieAdapter()

            viewModel.getMovie().observe(viewLifecycleOwner, { movie ->
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> _binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            _binding.progressBar.visibility = View.GONE
                            movieAdapter.submitList(movie.data)
                        }
                        Status.ERROR -> {
                            _binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(_binding.movieRvList) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = movieAdapter
            }

//            _binding.progressBar.visibility = View.VISIBLE
//            viewModel.getMovie().observe(viewLifecycleOwner, { movie ->
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
        }
    }

}