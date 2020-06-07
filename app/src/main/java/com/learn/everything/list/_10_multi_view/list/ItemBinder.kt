package com.learn.everything.list._10_multi_view.list

interface ItemBinder<T : Any> {
    fun onCreate(viewHolder: BinderViewHolder<T>)

    fun onBind(viewHolder: BinderViewHolder<T>, item: T)
}