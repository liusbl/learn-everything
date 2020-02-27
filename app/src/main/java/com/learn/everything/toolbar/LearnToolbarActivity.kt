package com.learn.everything.toolbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_learn_toolbar.*

class LearnToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_toolbar)
        simpleToolbarButton.setOnClickListener {
            startActivity(SimpleToolbarActivity.newInstance(this))
        }
    }

    companion object {
        fun createIntent(context: Context) =
            Intent(context, LearnToolbarActivity::class.java)
    }
}