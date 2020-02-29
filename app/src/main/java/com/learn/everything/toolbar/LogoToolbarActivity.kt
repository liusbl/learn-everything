package com.learn.everything.toolbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_learn_toolbar_simple.*

class LogoToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_toolbar_logo)
        setSupportActionBar(toolbar)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LogoToolbarActivity::class.java)
    }
}