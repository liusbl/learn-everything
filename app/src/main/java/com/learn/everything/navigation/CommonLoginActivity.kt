package com.learn.everything.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_navigation_common_login.*
import timber.log.Timber

class CommonLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_common_login)
        launchLoginCompletionActivityButton.setOnClickListener {
            startActivity(LoginCompletionActivity.createIntent(this))
        }
        launchLoginCompletionActivityForResultButton.setOnClickListener {
            startActivityForResult(LoginCompletionActivity.createIntent(this), 222)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Timber.d("TEST onActivityResult $requestCode, $resultCode, $data")
        if (resultCode == 111) {
            finish()
        } else if (resultCode == 333) {
            val intent = MainActivity.createIntent(this)
            startActivity(intent)
            finishAffinity()
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, CommonLoginActivity::class.java)
    }
}