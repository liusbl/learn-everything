package com.learn.everything.list._11_final

import com.learn.everything.R
import com.learn.everything.list._11_final.list.LayoutBinder

class FooterBinder : LayoutBinder<PersonListItem.Header>(
    R.layout.activity_list_final_footer_item,
    PersonListItem.ListType.FOOTER
)
