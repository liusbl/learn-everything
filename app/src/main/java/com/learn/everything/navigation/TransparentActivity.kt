package com.learn.everything.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_navigation_transparent.*

class TransparentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_transparent)
        launchMainActivityFinishButton.setOnClickListener {
            startActivity(MainActivity.createIntent(this))
            finish()
        }
        launchMainActivityFinishAffinityButton.setOnClickListener {
            startActivity(MainActivity.createIntent(this))
            Handler().postDelayed({
                finishAffinity()
            }, 200)
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, TransparentActivity::class.java)
    }
}