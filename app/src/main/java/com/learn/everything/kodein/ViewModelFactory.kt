package com.learn.everything.kodein

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.generic.instance

class ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val instance = kodein.instance<ViewModel>(tag = modelClass.simpleName) as BaseViewModel
        return instance.apply(BaseViewModel::onCreate) as T
    }
}