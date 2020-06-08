package com.learn.everything.list._10_multi_view.list

interface ItemBinder<T : Any> {
    // Sometimes not needed TODO add better comment with example
    fun onCreate(viewHolder: BinderViewHolder<T>) {
        // Empty
    }

    // Sometimes not needed TODO add better comment with example
    fun onBind(viewHolder: BinderViewHolder<T>, item: T) {
        // Empty
    }
}