package com.learn.everything.list._09_multi_view

import com.learn.everything.R
import com.learn.everything.list._09_multi_view.list.BinderViewHolder
import com.learn.everything.list._09_multi_view.list.LayoutBinder
import kotlinx.android.synthetic.main.activity_list_multi_view_header_item.*

class HeaderBinder : LayoutBinder<PersonListItem.Header>(
    R.layout.activity_list_multi_view_header_item,
    PersonListItem.ListType.HEADER
) {
    override fun onBind(viewHolder: BinderViewHolder<PersonListItem.Header>, item: PersonListItem.Header) {
        viewHolder.headerTextView.text = item.title
    }
}
