package com.learn.everything.list._05_binder.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class SingleViewTypeAdapter<T>(
    @LayoutRes private val itemLayout: Int
) : RecyclerView.Adapter<BinderViewHolder<T>>() {
    private val diffCallback: DiffUtil.ItemCallback<T> =
        DefaultDiffUtilItemCallback()
    private val listDiffer: AsyncListDiffer<T> by lazy { AsyncListDiffer(this, diffCallback) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinderViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(itemLayout, parent, false)
        return object : BinderViewHolder<T>(itemView) {
            override fun onBind(item: T) {
                onBind(this, item)
            }
        }
    }

    override fun onBindViewHolder(viewHolder: BinderViewHolder<T>, position: Int) {
        viewHolder.onBind(listDiffer.currentList[position])
    }

    abstract fun onBind(viewHolder: BinderViewHolder<T>, item: T)

    override fun getItemCount() = listDiffer.currentList.size

    fun setItems(list: List<T>) {
        listDiffer.submitList(list)
    }
}
