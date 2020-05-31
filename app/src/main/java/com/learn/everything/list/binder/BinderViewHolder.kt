package com.learn.everything.list.binder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BinderViewHolder<T>(
    itemView: View
) : RecyclerView.ViewHolder(itemView), Binder<T>
