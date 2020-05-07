package com.learn.everything

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.kodein.LearnKodeinActivity
import com.learn.everything.list.LearnListActivity
import com.learn.everything.toolbar.LearnToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        learnToolbarButton.setOnClickListener {
            startActivity(LearnToolbarActivity.createIntent(this))
        }
        learnKodein.setOnClickListener {
            startActivity(LearnKodeinActivity.createIntent(this))
        }
        learnList.setOnClickListener {
            startActivity(LearnListActivity.createIntent(this))
        }
    }
}
