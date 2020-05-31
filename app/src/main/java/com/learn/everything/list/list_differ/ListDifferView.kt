package com.learn.everything.list.list_differ

import com.learn.everything.list.simple_base.Person

interface ListDifferView {
    fun setPersonList(list: List<Person>)
}