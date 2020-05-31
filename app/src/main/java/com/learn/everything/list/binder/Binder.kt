package com.learn.everything.list.binder

interface Binder<T> {
    fun onBind(item: T)
}