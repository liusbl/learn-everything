package com.learn.everything.list._10_multi_view.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView

abstract class SingleViewTypeAdapter<T : Any>(
    @LayoutRes private val itemLayout: Int
) : RecyclerView.Adapter<BinderViewHolder<T>>(), ItemBinder<T> {
    private val diffCallback = DefaultDiffUtilItemCallback<T>()
    private val listDiffer by lazy { AsyncListDiffer(this, diffCallback) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinderViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(itemLayout, parent, false)
        return SingleViewHolder(this, itemView)
    }

    override fun onBindViewHolder(viewHolder: BinderViewHolder<T>, position: Int) {
        val item = listDiffer.currentList[position]
        viewHolder.item = item
        viewHolder.onCreate(viewHolder)
        viewHolder.onBind(viewHolder, item)
    }

    override fun getItemCount() = listDiffer.currentList.size

    fun setItems(list: List<T>) {
        listDiffer.submitList(list)
    }
}
