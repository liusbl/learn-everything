package com.learn.everything.list._10_diff_callback.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

abstract class SingleViewTypeAdapter<T : ListItem>(
    @LayoutRes private val itemLayout: Int
) : RecyclerView.Adapter<BinderViewHolder<T>>(), ItemBinder<T> {
    private val diffCallback = DefaultDiffUtilItemCallback<T>()
    /**
     * AsyncListDiffer automatically determines changes between old and new list,
     * making the appropriate onItemChanged, onItemMoved, etc. method calls.
     */
    private val listDiffer by lazy { AsyncListDiffer(this, diffCallback) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinderViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(itemLayout, parent, false)
        return BinderViewHolder(this, itemView)
    }

    override fun onBindViewHolder(viewHolder: BinderViewHolder<T>, position: Int) {
        val item = listDiffer.currentList[position]
        viewHolder.item = item
        viewHolder.onCreate(viewHolder)
        viewHolder.onBind(viewHolder, item)
    }

    override fun getItemCount() = listDiffer.currentList.size

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
        val adjustedList = list.toList().adjustIds()
        Timber.d("list: ${list.joinToString { item -> "$item ${item.stableId}" }}")
        Timber.d("adjustedList: ${adjustedList.joinToString { item -> "$item ${item.stableId}" }}")
        listDiffer.submitList(adjustedList)
    }
}
