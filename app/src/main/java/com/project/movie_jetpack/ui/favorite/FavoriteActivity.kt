package com.project.movie_jetpack.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.movie_jetpack.R
import com.project.movie_jetpack.databinding.ActivityFavoriteBinding
import com.project.movie_jetpack.databinding.ActivityHomeBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        supportActionBar?.title = (getString(R.string.favorite))

        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)
    }
}