package com.learn.everything.list._11_collapse_expand.list

class BinderNotFoundException(
    viewType: Int,
    binderList: List<LayoutBinder<*>>
) : RuntimeException(
    "A binder handling view type \"$viewType\" position was not found.\n" +
            "Currently the handled view types are: [${binderList.joinToString { it.viewType.name }}]"
)