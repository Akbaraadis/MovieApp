package com.project.movie_jetpack.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import com.project.movie_jetpack.R
import com.project.movie_jetpack.databinding.ActivityHomeBinding
import com.project.movie_jetpack.ui.favorite.FavoriteActivity
import com.project.movie_jetpack.ui.home.viewpager.ViewPagerAdapter

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.look_favorite) Intent(this, FavoriteActivity::class.java).also {
            startActivity(it)
        }
        return super.onOptionsItemSelected(item)
    }
}