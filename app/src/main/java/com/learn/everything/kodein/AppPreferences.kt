package com.learn.everything.kodein

interface AppPreferences {
    val name: String
}

class AppPreferencesImpl : AppPreferences {
    override val name: String = "test"
}