package com.learn.everything.list._10_diff_callback

import com.learn.everything.R
import com.learn.everything.list._10_diff_callback.list.LayoutBinder

class FooterBinder : LayoutBinder<PersonListItem.Header>(
    R.layout.activity_list_diff_callback_footer_item,
    PersonListItem.ListType.FOOTER
)
