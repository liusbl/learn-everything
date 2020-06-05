package com.learn.everything.list._09_diff_callback.list

import android.view.View

class SingleViewHolder<T : Any>(
    private val adapter: Binder<T>,
    itemView: View
) : BinderViewHolder<T>(itemView) {
    private var isCreated = false
        get() {
            val previous = field
            isCreated = true
            return previous
        }
    override lateinit var item: T

    override fun onCreate(viewHolder: BinderViewHolder<T>) {
        if (!isCreated) {
            adapter.onCreate(viewHolder)
        }
    }

    override fun onBind(viewHolder: BinderViewHolder<T>, item: T) {
        adapter.onBind(viewHolder, item)
    }
}
