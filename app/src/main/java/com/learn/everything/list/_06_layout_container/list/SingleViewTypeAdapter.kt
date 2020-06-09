package com.learn.everything.list._06_layout_container.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView

abstract class SingleViewTypeAdapter<T>(
    @LayoutRes private val itemLayout: Int
) : RecyclerView.Adapter<BinderViewHolder<T>>(), Binder<T> {
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
        viewHolder.onBind(viewHolder, listDiffer.currentList[position])
    }

    override fun getItemCount() = listDiffer.currentList.size

    /**
     * Recreating the list with "toList()" is necessary,
     * because even if you provide the same instance of a list,
     * then AsyncListDiffer will not trigger.
     */
    fun setItems(list: List<T>) {
        listDiffer.submitList(list.toList())
    }
}
