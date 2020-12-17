package com.learn.everything.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_navigation_onboard.*

class OnboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_onboard)
        launchCommonLoginActivity.setOnClickListener {
            startActivity(CommonLoginActivity.createIntent(this))
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, OnboardActivity::class.java)
    }
}