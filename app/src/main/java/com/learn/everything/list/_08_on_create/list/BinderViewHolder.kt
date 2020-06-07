package com.learn.everything.list._08_on_create.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

// REQUIRES build.gradle(app) update:  androidExtensions { experimental = true }
class BinderViewHolder<T : Any>(
    private val adapterBinder: Binder<T>,
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
            adapterBinder.onCreate(viewHolder)
        }
    }

    override fun onBind(viewHolder: BinderViewHolder<T>, item: T) {
        adapterBinder.onBind(viewHolder, item)
    }
}