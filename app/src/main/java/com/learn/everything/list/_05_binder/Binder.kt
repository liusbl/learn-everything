package com.learn.everything.list._05_binder

interface Binder<T> {
    fun onBind(item: T)
}