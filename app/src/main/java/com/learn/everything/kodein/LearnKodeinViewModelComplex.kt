package com.learn.everything.kodein

class LearnKodeinViewModelComplex(
    private val argumentProvider: ArgumentProvider<String>,
    private val prefs: AppPreferences
) : BaseViewModel() {
    fun test() {
        prefs.name
        argumentProvider.getArgument()
    }
}