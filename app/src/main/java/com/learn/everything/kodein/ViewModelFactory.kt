package com.learn.everything.kodein

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.generic.instance
import org.kodein.di.generic.on

class ViewModelFactory private constructor() {
    @Suppress("UNCHECKED_CAST")
    companion object {
        fun create(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val viewModel =
                    kodein.instance<ViewModel>(tag = modelClass.simpleName) as BaseViewModel
                return viewModel.apply(BaseViewModel::onCreate) as T
            }
        }

        inline fun <reified T> create(arg: T): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val viewModel = kodein.on(arg)
                        .instance<ViewModel>(tag = modelClass.simpleName) as BaseViewModel
                    return viewModel.apply(BaseViewModel::onCreate) as T
                }
            }
    }
}