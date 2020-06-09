package com.learn.everything.list._10_diff_callback.list

import androidx.annotation.LayoutRes

abstract class LayoutBinder<T : Any>(
    @LayoutRes val itemLayout: Int,
    val viewType: Enum<*>
) : ItemBinder<T>