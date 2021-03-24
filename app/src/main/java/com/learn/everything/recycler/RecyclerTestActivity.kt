package com.learn.everything.recycler

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import com.learn.everything.recycler.lib.LinearLayoutManager
import com.learn.everything.recycler.lib.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_test.*
import kotlinx.android.synthetic.main.activity_recycler_test_item.view.*

class RecyclerTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_test)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter()
    }

    class Adapter : RecyclerView.Adapter<Holder>() {
        val list = listOf(
            "Never",
            "Gonna",
            "Give",
            "You",
            "Up",
            "Let",
            "Down",
            "Desert",
            "And",
            "Even",
            "More",
            "Things"
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val inflater = LayoutInflater.from(parent.context)
            val itemView = inflater.inflate(R.layout.activity_recycler_test_item, parent, false)
            return Holder(itemView)
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount(): Int {
            return list.size
        }
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) {
            itemView.someTextView.text = item
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, RecyclerTestActivity::class.java)
    }
}