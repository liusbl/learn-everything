package com.learn.everything.camerax

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import com.learn.everything.camerax._01_official_sample.OfficialSample
import kotlinx.android.synthetic.main.activity_learn_camera_x.*

class LearnCameraXActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_camera_x)
        officialSampleButton.setOnClickListener {
            startActivity(OfficialSample.createIntent(this))
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LearnCameraXActivity::class.java)
    }
}