package com.learn.everything.list._10_diff_callback

import com.learn.everything.R
import com.learn.everything.list._10_diff_callback.list.BinderViewHolder
import com.learn.everything.list._10_diff_callback.list.LayoutBinder
import kotlinx.android.synthetic.main.activity_list_diff_callback_header_item.*

class HeaderBinder : LayoutBinder<PersonListItem.Header>(
    R.layout.activity_list_diff_callback_header_item,
    PersonListItem.ListType.HEADER
) {
    override fun onBind(viewHolder: BinderViewHolder<PersonListItem.Header>, item: PersonListItem.Header) {
        viewHolder.headerTextView.text = item.title
    }
}
