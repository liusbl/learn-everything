package com.learn.everything.list._11_collapse_expand.list

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