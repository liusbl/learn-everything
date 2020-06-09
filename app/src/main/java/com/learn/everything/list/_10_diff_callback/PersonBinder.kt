package com.learn.everything.list._10_diff_callback

import com.learn.everything.R
import com.learn.everything.list._10_diff_callback.list.BinderViewHolder
import com.learn.everything.list._10_diff_callback.list.LayoutBinder
import kotlinx.android.synthetic.main.activity_list_diff_callback_person_item.*

class PersonBinder : LayoutBinder<PersonListItem.Person>(
    R.layout.activity_list_diff_callback_person_item,
    PersonListItem.ListType.PERSON
) {
    override fun onBind(viewHolder: BinderViewHolder<PersonListItem.Person>, item: PersonListItem.Person) {
        viewHolder.nameTextView.alpha = 0f
        viewHolder.nameTextView.animate()
            .apply { duration = 500 }
            .alpha(1f)
            .start()
        viewHolder.nameTextView.text = item.name
    }
}
