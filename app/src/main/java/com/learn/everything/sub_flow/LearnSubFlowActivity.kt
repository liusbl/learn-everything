package com.learn.everything.sub_flow

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R


/**
 * This will be a demonstration of the sub-flow problem.
 * Also it will try to come up with possible solutions.
 *
 * It usually comes up as loading initial data,
 *  before which the screen Presenter should not be able to load data.
 *
 * All examples will use the same flow
 *
 * 
 */
class LearnSubFlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_sub_flow)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LearnSubFlowActivity::class.java)
    }
}