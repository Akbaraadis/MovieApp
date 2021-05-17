package com.project.movie_jetpack.ui.favorite.favseries

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
import com.project.movie_jetpack.databinding.FragmentFavseriesBinding

class FavSeriesFragment: Fragment(R.layout.fragment_favseries) {

    private lateinit var _binding : FragmentFavseriesBinding
    private lateinit var viewModel: FavSeriesViewModel
    private lateinit var seriesAdapter: FavSeriesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavseriesBinding.inflate(layoutInflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(_binding.seriesRvList)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavSeriesViewModel::class.java]

            seriesAdapter = FavSeriesAdapter()

            _binding.progressBar.visibility = View.VISIBLE
            viewModel.getFavoriteSeries().observe(viewLifecycleOwner, { series ->
                _binding.progressBar.visibility = View.GONE
                seriesAdapter.submitList(series)
            })

            with(_binding.seriesRvList) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = seriesAdapter
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
                val courseEntity = seriesAdapter.getSwipedData(swipedPosition)
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