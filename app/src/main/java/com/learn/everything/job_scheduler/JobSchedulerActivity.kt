package com.learn.everything.job_scheduler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R

/**
 * Resources:
 *
 * https://www.youtube.com/watch?list=PLWz5rJ2EKKc-lJo_RGGXL2Psr8vVCTWjM&v=XFN3MrnNhZA&ab_channel=AndroidDevelopers
 * Explains everything very nicely
 * https://medium.com/google-developers/scheduling-jobs-like-a-pro-with-jobscheduler-286ef8510129
 * https://developer.android.com/reference/android/app/job/JobService
 *
 */
class JobSchedulerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_job_scheduler)
    }
}