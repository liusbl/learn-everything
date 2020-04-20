package com.learn.everything.kodein

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learn.everything.App
import org.kodein.di.Kodein
import org.kodein.di.generic.*

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
        ViewModelFactory.create()
    }

    bindViewModel<LearnKodeinViewModelSimple>() with provider {
        LearnKodeinViewModelSimple(instance())
    }

    bindViewModelWithArgument<LearnKodeinViewModelComplex>() with
            contexted<ArgumentProvider<String>>().provider {
                LearnKodeinViewModelComplex(
                    context,
                    instance()
                )
            }
}

inline fun <reified VM : ViewModel> Kodein.Builder.bindViewModelWithArgument(
    overrides: Boolean? = null
): Kodein.Builder.TypeBinder<VM> {
    bind<ViewModelProvider.Factory>(
        tag = VM::class.java.simpleName
    ) with contexted<ArgumentProvider<String>>().provider {
        ViewModelFactory.create(context)
    }
    return bindViewModel()
}


inline fun <reified VM : ViewModel> Kodein.Builder.bindViewModel(
    overrides: Boolean? = null
): Kodein.Builder.TypeBinder<VM> = bind<VM>(
    tag = VM::class.java.simpleName,
    overrides = overrides
)


