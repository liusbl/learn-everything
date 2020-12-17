package com.learn.everything.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_learn_navigation.*

class LearnNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_navigation)
        launchOnboardActivityButton.setOnClickListener {
            startActivity(OnboardActivity.createIntent(this))
        }
        launchMainActivityButton.setOnClickListener {
            startActivity(MainActivity.createIntent(this))
        }
        launchTransparentActivityButton.setOnClickListener {
            startActivity(TransparentActivity.createIntent(this))
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LearnNavigationActivity::class.java)
    }
}