package com.learn.everything.list._05_binder.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class BinderViewHolder<T>(
    private val adapterBinder: Binder<T>,
    itemView: View
) : RecyclerView.ViewHolder(itemView), Binder<T> {
    override fun onBind(viewHolder: BinderViewHolder<T>, item: T) {
        adapterBinder.onBind(viewHolder, item)
    }
}
