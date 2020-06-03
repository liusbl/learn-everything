package com.learn.everything.list._08_on_create.lib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class SingleViewTypeAdapter<T : Any>(
    @LayoutRes private val itemLayout: Int
) : RecyclerView.Adapter<BinderViewHolder<T>>(), Binder<T> {
    private val diffCallback: DiffUtil.ItemCallback<T> =
        DefaultDiffUtilItemCallback()
    private val listDiffer: AsyncListDiffer<T> by lazy { AsyncListDiffer(this, diffCallback) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinderViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(itemLayout, parent, false)
        return ViewHolder(itemView)
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

    private inner class ViewHolder(itemView: View) : BinderViewHolder<T>(itemView) {
        private var isCreated = false
            get() {
                val previous = field
                isCreated = true
                return previous
            }
        override lateinit var item: T

        override fun onCreate(viewHolder: BinderViewHolder<T>) {
            if (!isCreated) {
                this@SingleViewTypeAdapter.onCreate(viewHolder)
            }
        }

        override fun onBind(viewHolder: BinderViewHolder<T>, item: T) {
            this@SingleViewTypeAdapter.onBind(viewHolder, item)
        }
    }
}
