package com.learn.everything.list._10_multi_view.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.learn.everything.list._09_diff_callback.list.DefaultDiffUtilItemCallback

// TODO convert binderList to vararg
abstract class MultiViewTypeAdapter<T : ListItem>(
    private val binderList: List<LayoutBinder<*>>
) : RecyclerView.Adapter<BinderViewHolder<T>>() {
    private val diffCallback = DefaultDiffUtilItemCallback<T>()
    private val listDiffer by lazy { AsyncListDiffer(this, diffCallback) }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinderViewHolder<T> {
        val binder = binderList.firstOrNull { it.viewType.ordinal == viewType }
            ?: throw BinderNotFoundException(viewType, binderList)
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(binder.itemLayout, parent, false)
        return BinderViewHolder(binder as ItemBinder<T>, itemView)
    }

    override fun onBindViewHolder(viewHolder: BinderViewHolder<T>, position: Int) {
        val item = listDiffer.currentList[position]
        viewHolder.item = item
        viewHolder.onCreate(viewHolder)
        viewHolder.onBind(viewHolder, item)
    }

    override fun getItemViewType(position: Int) = listDiffer.currentList[position].viewType.ordinal

    override fun getItemCount() = listDiffer.currentList.size

    /**
     * The item list is first wrapped as a new list, in order to avoid mutations of the list in an unintended scope.
     * Then all of the item IDs are adjusted to a more stable variant, in accordance to:
     *  * if the ID is a null - create a unique ID,
     *  * if the ID is not a null - append the ViewType and make it unique to that ViewType.
     */
    fun setItems(items: List<T>) {
        listDiffer.submitList(items.toList())
    }
}
