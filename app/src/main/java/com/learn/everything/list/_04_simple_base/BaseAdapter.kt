package com.learn.everything.list._04_simple_base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.learn.everything.list._07_listener_fail.list.DefaultDiffUtilItemCallback

abstract class BaseAdapter<T, VH : BaseViewHolder<T>>(
    @LayoutRes private val itemLayout: Int
) : RecyclerView.Adapter<VH>() {
    private val diffCallback = DefaultDiffUtilItemCallback<T>()
    private val listDiffer by lazy { AsyncListDiffer(this, diffCallback) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(itemLayout, parent, false)
        return createViewHolder(itemView)
    }

    abstract fun createViewHolder(itemView: View): VH

    override fun getItemCount() = listDiffer.currentList.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(listDiffer.currentList[position])
    }

    fun setItems(items: List<T>) {
        listDiffer.submitList(items.toList())
    }
}

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}