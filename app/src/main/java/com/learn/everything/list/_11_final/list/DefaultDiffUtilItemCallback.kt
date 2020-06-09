package com.learn.everything.list._11_final.list

import androidx.recyclerview.widget.DiffUtil
import java.util.*

class DefaultDiffUtilItemCallback<T : ListItem> : DiffUtil.ItemCallback<T>() {
    /**
     * Should provide unique identifier of the item.
     */
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.stableId == newItem.stableId

    /**
     * Determines whether items should be displayed differently.
     * Called only if areItemsTheSame == false.
     *
     * Usually equals() method or "=="
     */
    override fun areContentsTheSame(oldItem: T, newItem: T) = Objects.equals(oldItem, newItem)
}