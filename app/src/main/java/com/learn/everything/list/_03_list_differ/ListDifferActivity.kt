package com.learn.everything.list._03_list_differ

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
import kotlinx.android.synthetic.main.activity_list_differ.*
import kotlinx.android.synthetic.main.activity_list_differ_person_item.view.nameTextView

class ListDifferActivity : AppCompatActivity(), ListDifferView {
    private val adapter by lazy { PersonAdapter() }
    private val presenter by lazy { ListDifferPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_differ)
        personRecyclerView.adapter = adapter
        nextButton.setOnClickListener { presenter.onNextClick() }
        backButton.setOnClickListener { presenter.onBackClick() }
    }

    override fun setPersonList(list: List<Person>) {
        adapter.setItems(list)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, ListDifferActivity::class.java)
    }

    private inner class PersonAdapter : RecyclerView.Adapter<PersonViewHolder>() {
        private val diffCallback = PersonDiffUtilCallback()
        private val listDiffer by lazy { AsyncListDiffer(this, diffCallback) }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemView = inflater.inflate(R.layout.activity_list_differ_person_item, parent, false)
            return PersonViewHolder(itemView)
        }

        override fun getItemCount() = listDiffer.currentList.size

        override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
            holder.bind(listDiffer.currentList[position])
        }

        /**
         * Recreating the list with "toList()" is necessary,
         * because even if you provide the same instance of a list,
         * then AsyncListDiffer will not trigger.
         */
        fun setItems(list: List<Person>) {
            listDiffer.submitList(list.toList())
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