package com.learn.everything.activity_result

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.*
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
 * https://medium.com/@ajinkya.kolkhede1/requesting-runtime-permissions-using-new-activityresult-api-cb6116551f00
 *
 * BAD: registering contracts in user callbacks, like in setOnClickListener
 * GOOD: registering contracts in fields or during onCreate
 *
 * TODO Show example from our app, how it was refactored.
 */
class LearnActivityResultActivity : AppCompatActivity() {
    private val pickContactLauncher = registerForActivityResult(PickContact()) { result ->
        Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show()
        // To see proper result, you have to parse it accordingly.
    }

    private val singlePermissionLauncher = registerForActivityResult(RequestPermission()) { isGranted ->
        Toast.makeText(this, "Permission granted: $isGranted", Toast.LENGTH_SHORT).show()
    }

    private val multiplePermissionLauncher = registerForActivityResult(RequestMultiplePermissions()) { permissions ->
        val result = permissions.entries.joinToString(separator = "\n") { (permission, isGranted) ->
            "Permission: $permission, isGranted: $isGranted"
        }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }

    private val activityLauncher = registerForActivityResult(StartActivityForResult()) { result ->
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

        // Predefined contract
        pickContactButton.setOnClickListener {
            pickContactLauncher.launch(null)
        }

        // Single permission
        requestSinglePermissionButton.setOnClickListener {
            singlePermissionLauncher.launch(Manifest.permission.CALL_PHONE)
        }

        // Multiple permissions
        requestMultiplePermissionsButton.setOnClickListener {
            multiplePermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.READ_CONTACTS,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }

        // Test Activity
        launchActivityButton.setOnClickListener {
            activityLauncher.launch(ActivityWithResult.createIntent(this@LearnActivityResultActivity))
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