package com.learn.everything.list._11_final

import com.learn.everything.R
import com.learn.everything.list._11_final.list.BinderViewHolder
import com.learn.everything.list._11_final.list.LayoutBinder
import kotlinx.android.synthetic.main.activity_list_final_person_item.*

class PersonBinder : LayoutBinder<PersonListItem.Person>(
    R.layout.activity_list_final_person_item,
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
