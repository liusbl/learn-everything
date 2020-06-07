package com.learn.everything.list._09_diff_callback.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

// REQUIRES build.gradle(app) update:  androidExtensions { experimental = true }
class BinderViewHolder<T : Any>(
    private val adapter: Binder<T>,
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer, Binder<T> {
    private var isCreated = false
        get() {
            val previous = field
            isCreated = true
            return previous
        }
    lateinit var item: T

    override fun onCreate(viewHolder: BinderViewHolder<T>) {
        if (!isCreated) {
            adapter.onCreate(viewHolder)
        }
    }

    override fun onBind(viewHolder: BinderViewHolder<T>, item: T) {
        adapter.onBind(viewHolder, item)
    }
}