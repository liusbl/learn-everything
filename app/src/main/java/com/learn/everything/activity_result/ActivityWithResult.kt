package com.learn.everything.activity_result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import com.learn.everything.activity_result.LearnActivityResultActivity.Companion.EXTRA_RESULT_DATA
import kotlinx.android.synthetic.main.activity_with_result.*

class ActivityWithResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_result)
        finishButton.setOnClickListener {
            val toString = resultEditText.text.toString()
            val data = Intent().putExtra(EXTRA_RESULT_DATA, toString)
            setResult(LearnActivityResultActivity.ACTIVITY_RESULT_CODE, data)
            finish()
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, ActivityWithResult::class.java)
    }
}