package com.learn.everything.list._08_on_create.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

// REQUIRES build.gradle(app) update:  androidExtensions { experimental = true }
abstract class BinderViewHolder<T : Any>(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer, Binder<T> {
    abstract var item: T
}