package com.learn.everything.list._10_multi_view.list

import androidx.recyclerview.widget.DiffUtil

// FIXME: don't use this implementation
class DefaultDiffUtilItemCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem == newItem

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}