package com.learn.everything.list._08_on_create.lib

interface Binder<T : Any> {
    fun onCreate(viewHolder: BinderViewHolder<T>)

    fun onBind(viewHolder: BinderViewHolder<T>, item: T)
}