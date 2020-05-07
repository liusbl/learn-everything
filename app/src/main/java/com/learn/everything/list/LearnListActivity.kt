package com.learn.everything.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_learn_list.*

class LearnListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_list)
        listButton.setOnClickListener {
            startActivity(SimpleListActivity.createIntent(this))
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LearnListActivity::class.java)
    }
}