package com.learn.everything.kodein

interface ArgumentProvider<T> {
    fun getArgument(): T
}