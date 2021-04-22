package com.project.movie_jetpack.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.movie_jetpack.R
import com.project.movie_jetpack.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.title = (getString(R.string.movie_serries))

        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionsPagerAdapter = ViewPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.homeViewPager.adapter = sectionsPagerAdapter
        activityHomeBinding.homeTabs.setupWithViewPager(activityHomeBinding.homeViewPager)
        supportActionBar?.elevation = 0f
    }
}