package com.project.movie_jetpack.ui.favorite.viewpager

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.project.movie_jetpack.R
import com.project.movie_jetpack.ui.favorite.favmovie.FavMovieFragment
import com.project.movie_jetpack.ui.favorite.favseries.FavSeriesFragment

class FavViewPagerAdapter (private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tv_series)
    }

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> FavMovieFragment()
                1 -> FavSeriesFragment()
                else -> Fragment()
            }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2

}