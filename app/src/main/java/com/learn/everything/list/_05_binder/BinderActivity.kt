package com.learn.everything.list._05_binder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_list_binder.*
import kotlinx.android.synthetic.main.activity_list_binder_person_item.view.*

// 5
class BinderActivity : AppCompatActivity(), BinderView {
    private val adapter by lazy { PersonAdapter() }
    private val presenter by lazy { BinderPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_binder)
        personRecyclerView.adapter = adapter
        nextButton.setOnClickListener { presenter.onNextClick() }
        backButton.setOnClickListener { presenter.onBackClick() }
    }

    override fun setPersonList(list: List<Person>) {
        adapter.setItems(list)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, BinderActivity::class.java)
    }

    private inner class PersonAdapter : BinderAdapter<Person>(R.layout.activity_list_binder_person_item) {
        override fun onBind(viewHolder: BinderViewHolder<Person>, item: Person) {
            viewHolder.itemView.nameTextView.alpha = 0f
            viewHolder.itemView.nameTextView.animate()
                .apply { duration = 500 }
                .alpha(1f)
                .start()
            viewHolder.itemView.nameTextView.text = item.name
        }
    }
}