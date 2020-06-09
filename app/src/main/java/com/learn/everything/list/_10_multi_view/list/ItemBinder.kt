package com.learn.everything.list._10_multi_view.list

interface ItemBinder<T : Any> {
    /**
     * Sometimes onCreate does not need to be implemented,
     * therefore empty default implementation is provided
     */
    fun onCreate(viewHolder: BinderViewHolder<T>) {
        // Empty
    }

    /**
     * Sometimes onBind does not need to be implemented,
     * therefore empty default implementation is provided
     */
    fun onBind(viewHolder: BinderViewHolder<T>, item: T) {
        // Empty
    }
}