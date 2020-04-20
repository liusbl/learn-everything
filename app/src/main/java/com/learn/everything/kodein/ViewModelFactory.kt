package com.learn.everything.kodein

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.generic.instance
import org.kodein.di.generic.on

class ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val instance = kodein.instance<ViewModel>(tag = modelClass.simpleName) as BaseViewModel
        return instance.apply(BaseViewModel::onCreate) as T
    }

    companion object {
        inline fun <reified T> create(arg: T): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val viewModel = kodein.on(arg)
                        .instance<ViewModel>(tag = modelClass.simpleName) as BaseViewModel
                    return viewModel.apply(BaseViewModel::onCreate) as T
                }
            }
        }
    }
}