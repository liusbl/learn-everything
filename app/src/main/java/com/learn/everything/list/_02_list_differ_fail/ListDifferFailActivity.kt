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

// 2
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
        private val listDiffer = AsyncListDiffer(this, PersonDiffUtilCallback())

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemView = inflater.inflate(R.layout.activity_list_differ_fail_person_item, parent, false)
            return PersonViewHolder(itemView)
        }

        override fun getItemCount() = listDiffer.currentList.size

        override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
            holder.bind(listDiffer.currentList[position])
        }

        // OLD
//        fun setItems(list: List<Person>) {
//            this.list.clear()
//            this.list.addAll(list)
//            notifyDataSetChanged()
//        }

        // NEW
        fun setItems(list: List<Person>) {
            listDiffer.submitList(list)
        }
    }

    // FIXME: don't use this implementation
    private inner class PersonDiffUtilCallback : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem

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