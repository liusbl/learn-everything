package com.learn.everything.kodein

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.learn.everything.R

class LearnKodeinActivity : ViewModelActivity() {
    private val viewModelSimple by viewModel<LearnKodeinViewModelSimple>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_kodein)
        viewModelSimple.test()
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LearnKodeinActivity::class.java)
    }
}

