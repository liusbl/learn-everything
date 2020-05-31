package com.learn.everything.list.layout_container

interface Binder<T> {
    fun onBind(viewHolder: BinderViewHolder<T>, item: T)
}