package com.learn.everything.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import com.learn.everything.list._01_simple.SimpleListActivity
import com.learn.everything.list._02_list_differ_fail.ListDifferFailActivity
import com.learn.everything.list._03_list_differ.ListDifferActivity
import com.learn.everything.list._04_simple_base.SimpleBaseActivity
import com.learn.everything.list._05_binder.BinderActivity
import com.learn.everything.list._06_layout_container.LayoutContainerActivity
import com.learn.everything.list._07_listener_fail.ListenerFailActivity
import kotlinx.android.synthetic.main.activity_learn_list.*

class LearnListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_list)
        simpleListButton.setOnClickListener {
            startActivity(SimpleListActivity.createIntent(this))
        }
        listDifferFailButton.setOnClickListener {
            startActivity(ListDifferFailActivity.createIntent(this))
        }
        listDifferButton.setOnClickListener {
            startActivity(ListDifferActivity.createIntent(this))
        }
        simpleBaseButton.setOnClickListener {
            startActivity(SimpleBaseActivity.createIntent(this))
        }
        binderButton.setOnClickListener {
            startActivity(BinderActivity.createIntent(this))
        }
        layoutContainerButton.setOnClickListener {
            startActivity(LayoutContainerActivity.createIntent(this))
        }
        listenerFailButton.setOnClickListener {
            startActivity(ListenerFailActivity.createIntent(this))
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LearnListActivity::class.java)
    }
}