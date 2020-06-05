package com.learn.everything.list._09_diff_callback

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import com.learn.everything.list._09_diff_callback.list.BinderViewHolder
import com.learn.everything.list._09_diff_callback.list.SingleViewTypeAdapter
import kotlinx.android.synthetic.main.activity_list_diff_callback.*
import kotlinx.android.synthetic.main.activity_list_diff_callback_person_item.*

// 9
// TODO NOTHING WAS DONE HERE, WANTED TO EXPLAIN DIFFERENCE BETWEEN areItemsTheSame and areContentsTheSame
//  Possibly merge with _03_ or _02_ ?
class DiffCallbackActivity : AppCompatActivity(), DiffCallbackView {
    private val adapter by lazy { PersonAdapter() }
    private val presenter by lazy { DiffCallbackPresenter(this) }

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
        fun createIntent(context: Context) = Intent(context, DiffCallbackActivity::class.java)
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