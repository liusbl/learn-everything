package com.learn.everything.list._09_diff_callback.list

interface Binder<T : Any> {
    fun onCreate(viewHolder: BinderViewHolder<T>)

    fun onBind(viewHolder: BinderViewHolder<T>, item: T)
}