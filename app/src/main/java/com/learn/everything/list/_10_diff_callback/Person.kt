package com.learn.everything.list._10_diff_callback

import com.learn.everything.list._10_diff_callback.list.ListItem

sealed class PersonListItem(
    type: ListType,
    id: String?
) : ListItem(type, id) {
    data class Person(
        val id: String,
        val name: String
    ) : PersonListItem(ListType.PERSON, id)

    data class Header(
        val title: String
    ) : PersonListItem(ListType.HEADER, title)

    object Footer : PersonListItem(ListType.FOOTER, null)

    enum class ListType {
        PERSON,
        HEADER,
        FOOTER
    }
}