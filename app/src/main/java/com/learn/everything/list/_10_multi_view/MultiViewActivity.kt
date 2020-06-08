package com.learn.everything.list._10_multi_view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import com.learn.everything.list._10_multi_view.list.MultiViewTypeAdapter
import kotlinx.android.synthetic.main.activity_list_multi_view.*

class MultiViewActivity : AppCompatActivity(), MultiViewView {
    private val adapter by lazy { PersonAdapter() }
    private val presenter by lazy { MultiViewPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_multi_view)
        personRecyclerView.adapter = adapter
        presenter.onViewCreated()
    }

    override fun setPersonList(list: List<PersonListItem>) {
        adapter.setItems(list)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, MultiViewActivity::class.java)
    }

    private inner class PersonAdapter : MultiViewTypeAdapter<PersonListItem>(
        listOf(
            PersonBinder(presenter::onPersonUpdated),
            HeaderBinder()
        )
    )
}