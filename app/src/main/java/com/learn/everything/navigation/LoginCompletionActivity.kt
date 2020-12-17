package com.learn.everything.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_navigation_login_completion.*
import timber.log.Timber

// finishActivity(requestCode) : Finish a started activity!

class LoginCompletionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_login_completion)
//        launchMainActivityButtonNonSmooth.setOnClickListener {
//            // Non smooth transition
//            finishAffinity()
//            startActivity(MainActivity.createIntent(this))
//        }

//        launchMainActivityButtonSmooth.setOnClickListener {
//            // Smooth transition
//            val createIntent = MainActivity.createIntent(this)
//            startActivity(createIntent)
//            finishAffinity()
//        }

        launchMainActivityButtonForResult.setOnClickListener {
            // Smooth transition
            Timber.d("Launch main activity")
            setResult(333)
            finish()
        }

        launchMainActivityButtonAffinityDelay.setOnClickListener {
            val createIntent = MainActivity.createIntent(this)
            startActivity(createIntent)
            Handler().postDelayed({
                finishAffinity()
            }, 200)
        }

        closeStackUntilMainButton.setOnClickListener {
            Timber.d("Close stack")
            setResult(111)
            finish()
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LoginCompletionActivity::class.java)
    }
}