package com.learn.everything.list._07_listener_fail.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class SingleViewTypeAdapter<T>(
    @LayoutRes private val itemLayout: Int
) : RecyclerView.Adapter<BinderViewHolder<T>>(), Binder<T> {
    private val diffCallback = DefaultDiffUtilItemCallback<T>()
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

    fun setItems(list: List<T>) {
        listDiffer.submitList(list.toList())
    }
}
