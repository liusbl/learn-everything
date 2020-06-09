package com.learn.everything.list._08_on_create.list

import androidx.recyclerview.widget.DiffUtil

class DefaultDiffUtilItemCallback<T> : DiffUtil.ItemCallback<T>() {
    /**
     * Should provide unique identifier of the item.
     * FIXME this should check ids, not "==""
     */
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem == newItem

    /**
     * Determines whether items should be displayed differently.
     * Called only if areItemsTheSame == false.
     *
     * Usually equals() method or "=="
     */
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}