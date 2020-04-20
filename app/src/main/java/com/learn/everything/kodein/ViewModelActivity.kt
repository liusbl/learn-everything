package com.learn.everything.kodein

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.generic.instance
import org.kodein.di.generic.on

@Suppress("unused")
abstract class ViewModelActivity : AppCompatActivity() {
    protected fun <T> LiveData<T>.observe(action: (T) -> Unit) {
        observe({ lifecycle }, { data -> data?.let(action) })
    }

    protected inline fun <reified VM : BaseViewModel> viewModel(): Lazy<VM> =
        lazy { ViewModelProvider(this, kodein.instance()).get(VM::class.java) }


    protected inline fun <reified VM : BaseViewModel, reified T> viewModelWithArg(
        argument: T
    ): Lazy<VM> = lazy {
        ViewModelProvider(
            this,
            kodein.on(argument).instance(TAGGG)
        ).get(VM::class.java)
    }
}
