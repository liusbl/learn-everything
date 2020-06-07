package com.learn.everything.list._07_listener_fail.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

// REQUIRES build.gradle(app) update:  androidExtensions { experimental = true }
class BinderViewHolder<T>(
    private val adapterBinder: Binder<T>,
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer, Binder<T> {
    override fun onBind(viewHolder: BinderViewHolder<T>, item: T) {
        adapterBinder.onBind(viewHolder, item)
    }
}