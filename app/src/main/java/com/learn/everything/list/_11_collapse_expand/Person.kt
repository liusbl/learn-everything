package com.learn.everything.list._11_collapse_expand

import com.learn.everything.list._11_collapse_expand.list.ListItem

sealed class PersonListItem(
    type: ListType,
    id: String?
) : ListItem(type, id) {
    data class Person(
        val id: String,
        val name: String
    ) : PersonListItem(ListType.PERSON, id)

    data class Header(
        val title: String,
        val isExpanded: Boolean
    ) : PersonListItem(ListType.HEADER, title)

    enum class ListType {
        PERSON,
        HEADER
    }
}