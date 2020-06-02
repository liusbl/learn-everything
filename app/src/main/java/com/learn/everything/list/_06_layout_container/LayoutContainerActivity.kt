package com.learn.everything.list._06_layout_container

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_list_layout_container.*
import kotlinx.android.synthetic.main.activity_list_layout_container_person_item.*

// 6
class LayoutContainerActivity : AppCompatActivity(), LayoutContainerView {
    private val adapter by lazy { PersonAdapter() }
    private val presenter by lazy { LayoutContainerPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_layout_container)
        personRecyclerView.adapter = adapter
        nextButton.setOnClickListener { presenter.onNextClick() }
        backButton.setOnClickListener { presenter.onBackClick() }
    }

    override fun setPersonList(list: List<Person>) {
        adapter.setItems(list)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LayoutContainerActivity::class.java)
    }

    private inner class PersonAdapter : BinderAdapter<Person>(R.layout.activity_list_layout_container_person_item) {
        override fun onBind(viewHolder: BinderViewHolder<Person>, item: Person) {
            viewHolder.nameTextView.alpha = 0f
            viewHolder.nameTextView.animate()
                .apply { duration = 500 }
                .alpha(1f)
                .start()
            viewHolder.nameTextView.text = item.name
        }
    }
}