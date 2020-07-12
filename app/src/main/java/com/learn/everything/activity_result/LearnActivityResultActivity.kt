package com.learn.everything.activity_result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_learn_activity_result.*

/** As of 2020-07-02 requires alpha versions of these dependencies:
 * For Activity: androidx.activity:activity:1.2.0-alpha06
 * For Fragment: androidx.fragment:fragment:1.3.0-alpha06
 */
class LearnActivityResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_activity_result)

        // Test predefined ActivityResultContract
        pickContactButton.setOnClickListener {
            val activityResultLauncher = registerForActivityResult(ActivityResultContracts.PickContact()) { result ->
                Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show() // To see normal result, you have to parse it.
            }
            activityResultLauncher.launch(null)
        }

        // Test custom Activity


        // Test from Fragment

        // Test custom contract

        // Test something with lifecycle

        // Test multiple results
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LearnActivityResultActivity::class.java)
    }
}