package com.learn.everything.kodein

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learn.everything.App
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val kodein = Kodein.direct {
    bind<Context>() with provider { App.instance }
    import(prefsModule())
    import(viewModelModule())
}

private fun prefsModule() = Kodein.Module(name = "Preferences") {
    bind<AppPreferences>() with singleton { AppPreferencesImpl() }
}

private fun viewModelModule() = Kodein.Module(name = "ViewModel") {
    bind<ViewModelProvider.Factory>() with singleton {
        ViewModelFactory()
    }
    bindViewModel<LearnKodeinViewModelSimple>() with provider {
        LearnKodeinViewModelSimple(instance())
    }
}

inline fun <reified T : ViewModel> Kodein.Builder.bindViewModel(
    overrides: Boolean? = null
): Kodein.Builder.TypeBinder<T> = bind<T>(
    tag = T::class.java.simpleName,
    overrides = overrides
)


