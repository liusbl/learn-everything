package com.learn.everything.list._02_list_differ_fail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_list_differ_fail.*
import kotlinx.android.synthetic.main.activity_list_differ_fail_person_item.view.*
import timber.log.Timber

class ListDifferFailActivity : AppCompatActivity(), ListDifferFailView {
    private val adapter by lazy { PersonAdapter() }
    private val presenter by lazy { ListDifferFailPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_differ_fail)
        personRecyclerView.adapter = adapter
        nextButton.setOnClickListener { presenter.onNextClick() }
        backButton.setOnClickListener { presenter.onBackClick() }
    }

    override fun setPersonList(list: List<Person>) {
        Timber.d("Setting list: $list")
        adapter.setItems(list)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, ListDifferFailActivity::class.java)
    }

    private inner class PersonAdapter : RecyclerView.Adapter<PersonViewHolder>() {
        private val diffCallback = PersonDiffUtilCallback()
        /**
         * AsyncListDiffer automatically determines changes between old and new list,
         * making the appropriate onItemChanged, onItemMoved, etc. method calls.
         */
        private val listDiffer = AsyncListDiffer(this, diffCallback)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemView = inflater.inflate(R.layout.activity_list_differ_fail_person_item, parent, false)
            return PersonViewHolder(itemView)
        }

        override fun getItemCount() = listDiffer.currentList.size

        override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
            holder.bind(listDiffer.currentList[position])
        }

        /**
         * This replaces manual list handling.
         * However, this example doesn't work. Why?
         */
        fun setItems(list: List<Person>) {
            listDiffer.submitList(list)
        }
    }

    private inner class PersonDiffUtilCallback : DiffUtil.ItemCallback<Person>() {
        /**
         * Should provide unique identifier of the item.
         */
        override fun areItemsTheSame(oldItem: Person, newItem: Person) = oldItem.id == newItem.id

        /**
         * Determines whether items should be displayed differently.
         * Called only if areItemsTheSame == false.
         *
         * Usually equals() method or "=="
         */
        override fun areContentsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem
    }

    private inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(person: Person) {
            itemView.nameTextView.alpha = 0f
            itemView.nameTextView.animate().apply {
                    duration = 500
                }.alpha(1f)
                .start()
            itemView.nameTextView.text = person.name
        }
    }
}