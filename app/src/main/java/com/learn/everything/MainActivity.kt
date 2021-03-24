package com.learn.everything

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.recycler.RecyclerTestActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(RecyclerTestActivity.createIntent(this))

//        activityResultCardView.setOnClickListener {
//            startActivity(LearnActivityResultActivity.createIntent(this))
//        }
//        toolbarCardView.setOnClickListener {
//            startActivity(LearnToolbarActivity.createIntent(this))
//        }
//        listCardView.setOnClickListener {
//            startActivity(LearnListActivity.createIntent(this))
//        }
//        jobSchedulerCardView.setOnClickListener {
//            startActivity(LearnListActivity.createIntent(this))
//        }
//        fotoapparatCardView.setOnClickListener {
//            startActivity(LearnFotoapparatActivity.createIntent(this))
//        }
//        subFlowCardView.setOnClickListener {
//            startActivity(LearnSubFlowActivity.createIntent(this))
//        }
//        navigationCardView.setOnClickListener {
//            startActivity(LearnNavigationActivity.createIntent(this))
//        }
    }
}
