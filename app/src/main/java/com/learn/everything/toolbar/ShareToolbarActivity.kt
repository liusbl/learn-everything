package com.learn.everything.toolbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ShareActionProvider
import androidx.core.view.MenuItemCompat
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_learn_toolbar_simple.*


class ShareToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_toolbar_share)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_share, menu)
        val item = menu.findItem(R.id.actionShare)
        val actionProvider = MenuItemCompat.getActionProvider(item) as ShareActionProvider

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Something");

        actionProvider.setShareIntent(shareIntent)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.openSettingButton -> {
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, ShareToolbarActivity::class.java)
    }
}