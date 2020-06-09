package com.learn.everything.list._04_simple_base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_list_simple_base.*
import kotlinx.android.synthetic.main.activity_simple_base_person_item.view.*

class SimpleBaseActivity : AppCompatActivity(), SimpleBaseView {
    private val adapter by lazy { PersonAdapter() }
    private val presenter by lazy { SimpleBasePresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_simple_base)
        personRecyclerView.adapter = adapter
        nextButton.setOnClickListener { presenter.onNextClick() }
        backButton.setOnClickListener { presenter.onBackClick() }
    }

    override fun setPersonList(list: List<Person>) {
        adapter.setItems(list)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, SimpleBaseActivity::class.java)
    }

    private inner class PersonAdapter : BaseAdapter<Person, PersonViewHolder>(
        R.layout.activity_simple_base_person_item
    ) {
        override fun createViewHolder(itemView: View) = PersonViewHolder(itemView)
    }

    private inner class PersonViewHolder(itemView: View) : BaseViewHolder<Person>(itemView) {
        override fun bind(item: Person) {
            itemView.nameTextView.alpha = 0f
            itemView.nameTextView.animate()
                .apply { duration = 500 }
                .alpha(1f)
                .start()
            itemView.nameTextView.text = item.name
        }
    }
}