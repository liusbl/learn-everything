package com.learn.everything

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class AppEditText : AppCompatEditText {
    private val listeners = mutableListOf<TextWatcher>()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun addTextChangedListener(watcher: TextWatcher?) {
        error("Should call onTextChanged") // TODO probably not the best idea to throw exception
    }

    fun onTextChange(onChange: (text: String) -> Unit) {
        clearListeners()
        val listener = object : TextWatcher {
            override fun afterTextChanged(value: Editable?) {
                value?.toString()?.let(onChange::invoke)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Empty
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Empty
            }
        }
        super.addTextChangedListener(listener)
        listeners.add(listener)
    }

    private fun clearListeners() {
        listeners.forEach {
            super.removeTextChangedListener(it)
        }
        listeners.clear()
    }

    fun setSafeText(text: String) {
        listeners.forEach(::removeTextChangedListener)
        if (text != getText().toString()) {
            setText(text)
        }
        listeners.forEach { super.addTextChangedListener(it) }
    }

    fun isSelectionEnabled(enabled: Boolean) {
        isFocusable = enabled
        isCursorVisible = enabled
        setTextIsSelectable(enabled)
    }
}