package com.learn.everything

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.activity_result.LearnActivityResultActivity
import com.learn.everything.fotoapparat.LearnFotoapparatActivity
import com.learn.everything.list.LearnListActivity
import com.learn.everything.navigation.LearnNavigationActivity
import com.learn.everything.sub_flow.LearnSubFlowActivity
import com.learn.everything.toolbar.LearnToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbarCardView.setOnClickListener {
            startActivity(LearnToolbarActivity.createIntent(this))
        }
        listCardView.setOnClickListener {
            startActivity(LearnListActivity.createIntent(this))
        }
        jobSchedulerCardView.setOnClickListener {
            startActivity(LearnListActivity.createIntent(this))
        }
        activityResultCardView.setOnClickListener {
            startActivity(LearnActivityResultActivity.createIntent(this))
        }
        fotoapparatCardView.setOnClickListener {
            startActivity(LearnFotoapparatActivity.createIntent(this))
        }
        subFlowCardView.setOnClickListener {
            startActivity(LearnSubFlowActivity.createIntent(this))
        }
        navigationCardView.setOnClickListener {
            startActivity(LearnNavigationActivity.createIntent(this))
        }
    }
}
