package com.learn.everything.list._10_multi_view

import android.text.Editable
import android.text.TextWatcher
import com.learn.everything.R
import com.learn.everything.list._10_multi_view.list.BinderViewHolder
import com.learn.everything.list._10_multi_view.list.LayoutBinder
import kotlinx.android.synthetic.main.activity_list_multi_view_person_item.*

class PersonBinder(
    private val onPersonUpdated: (PersonListItem.Person) -> Unit
) : LayoutBinder<PersonListItem.Person>(
    R.layout.activity_list_multi_view_person_item,
    PersonListItem.ListType.PERSON
) {
    override fun onCreate(viewHolder: BinderViewHolder<PersonListItem.Person>) {
        viewHolder.nameTextView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                onPersonUpdated(viewHolder.item.copy(name = s!!.toString()))
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Empty
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Empty
            }
        })
    }

    override fun onBind(viewHolder: BinderViewHolder<PersonListItem.Person>, item: PersonListItem.Person) {
        viewHolder.nameTextView.alpha = 0f
        viewHolder.nameTextView.animate()
            .apply { duration = 500 }
            .alpha(1f)
            .start()
        viewHolder.nameTextView.text = item.name
    }
}
