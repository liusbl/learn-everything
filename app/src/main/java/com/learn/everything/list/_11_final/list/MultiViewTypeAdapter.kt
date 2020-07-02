package com.learn.everything.list._11_final.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import inflate

/**
 * ListAdapter uses AsyncListDiffer to automatically determine changes between old and new list,
 * making the appropriate onItemChanged, onItemMoved, etc. method calls.
 */
abstract class MultiViewTypeAdapter<T : ListItem>(
    private val binderList: List<LayoutBinder<*>>
) : ListAdapter<T, BinderViewHolder<T>>(DefaultDiffUtilItemCallback<T>()) {
    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinderViewHolder<T> {
        val binder = binderList.firstOrNull { it.viewType.ordinal == viewType }
            ?: throw BinderNotFoundException(viewType, binderList)
        val itemView = parent.inflate(binder.itemLayout)
        return BinderViewHolder(binder as ItemBinder<T>, itemView)
    }

    override fun onBindViewHolder(viewHolder: BinderViewHolder<T>, position: Int) {
        val item = currentList[position]
        viewHolder.item = item
        viewHolder.onCreate(viewHolder)
        viewHolder.onBind(viewHolder, item)
    }

    /**
     * When using multiple viewTypes, getItemViewType must be implemented.
     * Here we provide the Enum value.
     */
    override fun getItemViewType(position: Int) = currentList[position].viewType.ordinal

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
