package com.learn.everything.list._03_list_differ

import com.learn.everything.list._04_simple_base.Person

interface ListDifferView {
    fun setPersonList(list: List<Person>)
}