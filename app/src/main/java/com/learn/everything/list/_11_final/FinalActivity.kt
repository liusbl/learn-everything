package com.learn.everything.list._11_final

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import com.learn.everything.list._11_final.list.MultiViewTypeAdapter
import kotlinx.android.synthetic.main.activity_list_multi_view.*

class FinalActivity : AppCompatActivity(), FinalView {
    private val adapter by lazy { PersonAdapter() }
    private val presenter by lazy { FinalPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_final)
        personRecyclerView.adapter = adapter
        presenter.onViewCreated()
    }

    override fun setPersonList(list: List<PersonListItem>) {
        adapter.setItems(list)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, FinalActivity::class.java)
    }

    private inner class PersonAdapter : MultiViewTypeAdapter<PersonListItem>(
        listOf(
            PersonBinder(),
            HeaderBinder(),
            FooterBinder()
        )
    )
}