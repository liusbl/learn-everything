package com.learn.everything.list._07_listener_fail.list

interface Binder<T> {
    fun onBind(viewHolder: BinderViewHolder<T>, item: T)
}