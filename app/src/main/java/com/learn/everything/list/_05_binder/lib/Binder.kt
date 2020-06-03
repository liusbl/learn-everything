package com.learn.everything.list._05_binder.lib

interface Binder<T> {
    fun onBind(item: T)
}