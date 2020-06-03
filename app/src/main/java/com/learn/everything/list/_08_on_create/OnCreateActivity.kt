package com.learn.everything.list._08_on_create

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import com.learn.everything.list._08_on_create.lib.SingleViewTypeAdapter
import com.learn.everything.list._08_on_create.lib.BinderViewHolder
import kotlinx.android.synthetic.main.activity_list_listener_fail.*
import kotlinx.android.synthetic.main.activity_list_listener_fail_person_item.*

// 8
class OnCreateActivity : AppCompatActivity(), OnCreateView {
    private val adapter by lazy { PersonAdapter() }
    private val presenter by lazy { OnCreatePresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_on_create)
        personRecyclerView.adapter = adapter
        nextButton.setOnClickListener { presenter.onNextClick() }
        backButton.setOnClickListener { presenter.onBackClick() }
    }

    override fun setPersonList(list: List<Person>) {
        adapter.setItems(list)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, OnCreateActivity::class.java)
    }

    private inner class PersonAdapter : SingleViewTypeAdapter<Person>(R.layout.activity_list_on_create_person_item) {
        override fun onCreate(viewHolder: BinderViewHolder<Person>) {
            viewHolder.nameEditText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    presenter.onPersonUpdated(viewHolder.item.copy(name = s!!.toString()))
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    // Empty
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // Empty
                }
            })
        }

        override fun onBind(viewHolder: BinderViewHolder<Person>, item: Person) {
            viewHolder.nameEditText.alpha = 0f
            viewHolder.nameEditText.animate()
                .apply { duration = 500 }
                .alpha(1f)
                .start()
            viewHolder.nameEditText.setText(item.name)
        }
    }
}