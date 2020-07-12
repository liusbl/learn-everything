package com.learn.everything.camerax

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R

class BasicUsageActivity : AppCompatActivity() {
    override fun setContentView(view: View?) {
        super.setContentView(view)
        setContentView(R.layout.activity_learn_camera_x_basic_usage)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, BasicUsageActivity::class.java)
    }
}