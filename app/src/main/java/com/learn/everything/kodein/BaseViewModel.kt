package com.learn.everything.kodein

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    @CallSuper
    override fun onCleared() {
        super.onCleared()
        onClear()
    }

    open fun onCreate() {
        // Empty
    }

    open fun onClear() {
        // Empty
    }
}
