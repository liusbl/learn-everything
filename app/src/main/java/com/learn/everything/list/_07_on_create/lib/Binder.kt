package com.learn.everything.list._07_on_create.lib

interface Binder<T> {
    fun onBind(viewHolder: BinderViewHolder<T>, item: T)
}