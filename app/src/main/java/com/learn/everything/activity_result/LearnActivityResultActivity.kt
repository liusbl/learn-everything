package com.learn.everything.activity_result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.learn.everything.R
import kotlinx.android.synthetic.main.activity_learn_activity_result.*

/** As of 2021-21 requires release candidate versions of these dependencies:
 * For Activity: androidx.activity:activity:1.2.0-rc01
 * For Fragment: androidx.fragment:fragment:1.3.0-rc01
 *
 * References:
 * https://developer.android.com/training/basics/intents/result
 * https://adambennett.dev/2020/03/introducing-the-activity-result-apis/
 */
class LearnActivityResultActivity : AppCompatActivity() {

    val contract = ActivityResultContracts.StartActivityForResult()
    val launcher = registerForActivityResult(contract) { result: ActivityResult ->
        if (result.resultCode == ACTIVITY_RESULT_CODE) {
            val intent = result.data
            val text = intent?.getStringExtra(EXTRA_RESULT_DATA)
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }

    // registerForActivityResult MUST be called in onCreate OR in a field!
    //  It must not be called in setOnClickListener

    // Also important, don't dismiss the provided Contracts.
    // Provide example from our latest PR
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_activity_result)

        // TODO write a short description about this, link to documentation, etc.

        // TODO use dynamic list for things.

        // Test predefined ActivityResultContract
        run {
            val contract = ActivityResultContracts.PickContact()
            val launcher = registerForActivityResult(contract) { result ->
                Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show()
                // To see proper result, you have to parse it accordingly.
            }
            pickContactButton.setOnClickListener {
                launcher.launch(null)
            }
        }

        // Test Single RequestPermission TODO not working
        run {
            val contract = ActivityResultContracts.RequestPermission()
            val launcher = registerForActivityResult(contract) { result ->
                Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show()
            }
            requestLocationPermissionButton.setOnClickListener {
                launcher.launch(null)
            }
        }

        // Test Activity
        run {

            launchActivityButton.setOnClickListener {
                launcher.launch(ActivityWithResult.createIntent(this@LearnActivityResultActivity))
            }
        }

        // Test from Fragment
        run {

        }

        // Test custom contract https://developer.android.com/training/basics/intents/result#custom

        // Test something with lifecycle

        // Test multiple results

        // Test Multiple RequestPermissions

        //
    }

    companion object {
        const val ACTIVITY_RESULT_CODE = 123
        const val EXTRA_RESULT_DATA = "extra.result_data"

        fun createIntent(context: Context) = Intent(context, LearnActivityResultActivity::class.java)
    }
}