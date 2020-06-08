package com.learn.everything.list._11_collapse_expand.list

import androidx.annotation.LayoutRes

abstract class LayoutBinder<T : Any>(
    @LayoutRes val itemLayout: Int,
    val viewType: Enum<*>
) : ItemBinder<T>