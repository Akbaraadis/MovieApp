package com.project.movie_jetpack.ui.favorite.favseries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.viewmodel.ViewModelFactory
import com.project.movie_jetpack.databinding.FragmentFavseriesBinding

class FavSeriesFragment: Fragment(R.layout.fragment_favseries) {

    private lateinit var _binding : FragmentFavseriesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavseriesBinding.inflate(layoutInflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavSeriesViewModel::class.java]

            val movieAdapter = FavSeriesAdapter()
            _binding.progressBar.visibility = View.VISIBLE
            viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { series ->
                _binding.progressBar.visibility = View.GONE
                movieAdapter.setseries(series)
                movieAdapter.notifyDataSetChanged()
            })

            with(_binding.seriesRvList) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}