package com.learn.everything.list._10_multi_view

import com.learn.everything.list._10_multi_view.list.ListItem

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
    ) : PersonListItem(ListType.HEADER, null)

    enum class ListType {
        PERSON,
        HEADER
    }
}