package com.learn.everything.list._06_layout_container.list

interface Binder<T> {
    fun onBind(viewHolder: BinderViewHolder<T>, item: T)
}