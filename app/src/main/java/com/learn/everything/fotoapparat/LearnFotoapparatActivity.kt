package com.learn.everything.fotoapparat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import com.learn.everything.fotoapparat._01_basic_usage.BasicUsageActivity
import kotlinx.android.synthetic.main.activity_learn_fotoapparat.*

class LearnFotoapparatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_fotoapparat)
        basicUsageButton.setOnClickListener {
            startActivity(BasicUsageActivity.createIntent(this))
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LearnFotoapparatActivity::class.java)
    }
}