package com.learn.everything.fotoapparat._01_basic_usage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import io.fotoapparat.Fotoapparat
import kotlinx.android.synthetic.main.activity_learn_fotoapparat_basic_usage.*

class BasicUsageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_fotoapparat_basic_usage)

        val fotoapparat = Fotoapparat.with(this)
            .into(cameraView)
            .build()
        fotoapparat.start()

        button.setOnClickListener {
            fotoapparat.takePicture()
                .toBitmap()
                .whenAvailable { photo ->
                    Toast.makeText(this, photo?.rotationDegrees.toString(), Toast.LENGTH_SHORT).show()
                }
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, BasicUsageActivity::class.java)
    }
}