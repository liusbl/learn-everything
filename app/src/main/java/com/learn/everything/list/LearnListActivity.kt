package com.learn.everything.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import com.learn.everything.list.binder.BinderActivity
import com.learn.everything.list.list_differ.ListDifferActivity
import com.learn.everything.list.list_differ_fail.ListDifferFailActivity
import com.learn.everything.list.simple.SimpleListActivity
import com.learn.everything.list.simple_base.SimpleBaseActivity
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
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LearnListActivity::class.java)
    }
}