package com.learn.everything.list._10_multi_view.list

interface ListItem {
    open fun getViewType(): Enum<*> = DefaultViewType.EMPTY

    enum class DefaultViewType {
        EMPTY
    }
}