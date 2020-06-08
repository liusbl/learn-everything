package com.learn.everything.list._11_collapse_expand

import com.learn.everything.R
import com.learn.everything.list._11_collapse_expand.list.BinderViewHolder
import com.learn.everything.list._11_collapse_expand.list.LayoutBinder
import kotlinx.android.synthetic.main.activity_list_multi_view_header_item.*

class HeaderBinder(
    private val onItemClick: (PersonListItem.Header) -> Unit
) : LayoutBinder<PersonListItem.Header>(
    R.layout.activity_list_collapse_expand_header_item,
    PersonListItem.ListType.HEADER
) {
    override fun onCreate(viewHolder: BinderViewHolder<PersonListItem.Header>) {
        viewHolder.itemView.setOnClickListener { onItemClick(viewHolder.item) }
    }

    override fun onBind(viewHolder: BinderViewHolder<PersonListItem.Header>, item: PersonListItem.Header) {
        viewHolder.headerTextView.text = item.title
    }
}