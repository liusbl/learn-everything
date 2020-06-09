package com.learn.everything.list._11_final

import com.learn.everything.R
import com.learn.everything.list._11_final.list.BinderViewHolder
import com.learn.everything.list._11_final.list.LayoutBinder
import kotlinx.android.synthetic.main.activity_list_final_header_item.*

class HeaderBinder : LayoutBinder<PersonListItem.Header>(
    R.layout.activity_list_final_header_item,
    PersonListItem.ListType.HEADER
) {
    override fun onBind(viewHolder: BinderViewHolder<PersonListItem.Header>, item: PersonListItem.Header) {
        viewHolder.headerTextView.text = item.title
    }
}
