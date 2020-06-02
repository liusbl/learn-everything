package com.learn.everything.list._05_binder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BinderViewHolder<T>(
    itemView: View
) : RecyclerView.ViewHolder(itemView), Binder<T>
