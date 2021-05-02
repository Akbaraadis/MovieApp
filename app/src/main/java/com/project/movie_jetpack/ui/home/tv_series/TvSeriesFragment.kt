package com.project.movie_jetpack.ui.home.tv_series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.movie_jetpack.R
import com.project.movie_jetpack.databinding.FragmentSeriesBinding

class TvSeriesFragment: Fragment(R.layout.fragment_series) {

    private lateinit var _binding : FragmentSeriesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSeriesBinding.inflate(layoutInflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvSeriesViewModel::class.java]
            val viewserries = viewModel.getSerries()

            val movieAdapter = TvSeriesAdapter()
            movieAdapter.setmovies(viewserries)
            with(_binding.seriesRvList) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}