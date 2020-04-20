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
        ViewModelFactory()
    }

    bindViewModel<LearnKodeinViewModelSimple>() with provider {
        LearnKodeinViewModelSimple(instance())
    }

    bind<ViewModelProvider.Factory>(
        tag = TAGGG
    ) with contexted<ArgumentProvider<String>>().provider {
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val viewModel = on(context)
                    .instance<LearnKodeinViewModelComplex>(tag = TAGGG) as BaseViewModel
                return viewModel.apply(BaseViewModel::onCreate) as T
            }
        }
    }

    bind<LearnKodeinViewModelComplex>(
        tag = TAGGG
    ) with contexted<ArgumentProvider<String>>().provider {
        LearnKodeinViewModelComplex(
            context,
            instance()
        )
    }
}

inline fun <reified T : ViewModel> Kodein.Builder.bindViewModel(
    overrides: Boolean? = null
): Kodein.Builder.TypeBinder<T> = bind<T>(
    tag = T::class.java.simpleName,
    overrides = overrides
)


