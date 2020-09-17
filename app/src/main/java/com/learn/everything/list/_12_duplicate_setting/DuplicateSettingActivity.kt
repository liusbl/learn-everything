package com.learn.everything.list._12_duplicate_setting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_duplicate_setting_person_item.view.*
import kotlinx.android.synthetic.main.activity_list_duplicate_setting.*

// TODO
class DuplicateSettingActivity : AppCompatActivity() {
    private val adapter by lazy { PersonAdapter() }

    private val list = mutableListOf(
        Person("0", "Cartman"),
        Person("1", "Stan"),
        Person("2", "Kyle"),
        Person("3", "Kenny"),
        Person("4", "Gerald"),
        Person("5", "Randy"),
        Person("6", "Butters"),
        Person("7", "Ike"),
        Person("8", "Wendy"),
        Person("9", "Ms. Chokesondick"),
        Person("10", "Mackey"),
        Person("11", "PC principal"),
        Person("12", "Jimmy"),
        Person("13", "Timmy"),
        Person("14", "Garrison"),
        Person("15", "Mr. Slave"),
        Person("16", "Chef"),
        Person("17", "Scott Tenorman"),
        Person("18", "Craig")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_duplicate_setting)
        personRecyclerView.adapter = adapter
        adapter.setItems(list)
    }

    fun onPersonUpdated(person: Person, name: String) {
        val index = list.indexOf(person)
        if (index >= 0) {
            val updatedPerson = person.copy(name = name)
            list[index] = updatedPerson
            adapter.setInternal(list)
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, DuplicateSettingActivity::class.java)
    }

    private inner class PersonAdapter : ListAdapter<Person, PersonViewHolder>(
        object : DiffUtil.ItemCallback<Person>() {
            override fun areItemsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem
        }
    ) {
        private var list = listOf<Person>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemView = inflater.inflate(R.layout.activity_duplicate_setting_person_item, parent, false)
            return PersonViewHolder(itemView).also {
                it.onCreate()
            }
        }

        override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItem(position: Int): Person {
            return this.list[position]
        }

        fun setInternal(list: List<Person>) {
            this.list = list
        }

        fun setItems(list: List<Person>) {
            this.list = list
            submitList(list.toList())
        }
    }

    private inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var person: Person
            private set

        fun onCreate() {
            itemView.nameEditText.onTextChange { name ->
                onPersonUpdated(person, name)
            }
        }

        fun bind(person: Person) {
            this.person = person
            itemView.nameEditText.setSafeText(person.name)
        }
    }
}