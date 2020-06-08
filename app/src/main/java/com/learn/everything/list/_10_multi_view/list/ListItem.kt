package com.learn.everything.list._10_multi_view.list

// TODO maybe should be interface?
open class ListItem(
    val viewType: Enum<*>,
    private val id: String?
)