package com.learn.everything.list._05_binder.list

interface Binder<T> {
    fun onBind(viewHolder: BinderViewHolder<T>, item: T)
}