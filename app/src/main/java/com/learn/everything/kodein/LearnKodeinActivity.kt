package com.learn.everything.kodein

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.learn.everything.R
import org.kodein.di.generic.instance
import org.kodein.di.generic.on

val TAGGG = LearnKodeinViewModelComplex::class.java.simpleName

// Idea: Inject argument provider instead of fragment
class LearnKodeinActivity : ViewModelActivity(), ArgumentProvider<String> {
    private val viewModelSimple by viewModel<LearnKodeinViewModelSimple>()

    private val viewModelComplex by lazy {
        ViewModelProvider(
            this,
            kodein.on(this as ArgumentProvider<String>)
                .instance(TAGGG)
        ).get(LearnKodeinViewModelComplex::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_learn_kodein)
        viewModelSimple.test()
        viewModelComplex.test()
    }

    override fun getArgument() = "arg"

    companion object {
        fun createIntent(context: Context) = Intent(context, LearnKodeinActivity::class.java)
    }
}

