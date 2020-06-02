package com.learn.everything.list._01_simple

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_simple_list.*
import kotlinx.android.synthetic.main.activity_simple_list_person_item.view.*

// 1
class SimpleListActivity : AppCompatActivity() {
    private val adapter: PersonAdapter by lazy { PersonAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list)
        personRecyclerView.adapter = adapter

        var count = 0
        button.setOnClickListener {
            if (count % 2 == 0) {
                adapter.setItems(
                    listOf(
                        Person("0", "Stan"),
                        Person("1", "Kyle"),
                        Person("2", "Cartman"),
                        Person("3", "Kenny"),
                        Person("4", "Craig"),
                        Person("5", "Butters"),
                        Person("6", "Ike")
                    )
                )
            } else {
                adapter.setItems(
                    listOf(
                        Person("0", "Stan"),
                        Person("1", "Kyle"),
                        Person("3", "Kenny"), // Items flipped
                        Person("2", "Cartman"), // Items flipped
                        Person("4", "Craig"),
                        Person("5", "Butters"),
                        Person("6", "Ike")
                    )
                )
            }
            count++
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, SimpleListActivity::class.java)
    }

    private inner class PersonAdapter : RecyclerView.Adapter<PersonViewHolder>() {
        private val list = mutableListOf<Person>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemView =
                inflater.inflate(R.layout.activity_simple_list_person_item, parent, false)
            return PersonViewHolder(itemView)
        }

        override fun getItemCount() = list.size

        override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
            holder.bind(list[position])
        }

        fun setItems(list: List<Person>) {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
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