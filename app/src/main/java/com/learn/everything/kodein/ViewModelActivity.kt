package com.learn.everything.kodein

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.generic.instance

@Suppress("unused")
abstract class ViewModelActivity : AppCompatActivity() {
    protected fun <T> LiveData<T>.observe(action: (T) -> Unit) {
        observe({ lifecycle }, { data -> data?.let(action) })
    }

    protected inline fun <reified VM : BaseViewModel> viewModel(): Lazy<VM> =
        lazy { ViewModelProvider(this, kodein.instance()).get(VM::class.java) }
}
