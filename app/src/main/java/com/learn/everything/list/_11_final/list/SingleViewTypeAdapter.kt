package com.learn.everything.list._11_final.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * ListAdapter uses AsyncListDiffer to automatically determine changes between old and new list,
 * making the appropriate onItemChanged, onItemMoved, etc. method calls.
 */
abstract class SingleViewTypeAdapter<T : ListItem>(
    @LayoutRes private val itemLayout: Int
) : ListAdapter<T, BinderViewHolder<T>>(DefaultDiffUtilItemCallback<T>()), ItemBinder<T> {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinderViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(itemLayout, parent, false)
        return BinderViewHolder(this, itemView)
    }

    override fun onBindViewHolder(viewHolder: BinderViewHolder<T>, position: Int) {
        val item = currentList[position]
        viewHolder.item = item
        viewHolder.onCreate(viewHolder)
        viewHolder.onBind(viewHolder, item)
    }

    /**
     * Providing stableId values allows some viewHolder optimizations
     */
    override fun getItemId(position: Int): Long =
        (currentList[position] as? ListItem)?.stableId ?: RecyclerView.NO_ID

    /**
     * Recreating the list with "toList()" is necessary,
     * because even if you provide the same instance of a list,
     * then AsyncListDiffer will not trigger.
     *
     * All of the item IDs are adjusted to a more stable variant, in accordance to:
     *  if the ID is a null - create a unique ID,
     *  if the ID is not a null - append the ViewType and make it unique to that ViewType.
     */
    fun setItems(list: List<T>) {
        submitList(list.toList().adjustIds())
    }
}
