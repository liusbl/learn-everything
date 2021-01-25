package com.learn.everything.activity_result

import android.Manifest
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
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
 *  - Full documentation:
 *      - https://developer.android.com/training/basics/intents/result
 *  - List of predefined Contracts:
 *      - https://developer.android.com/reference/androidx/activity/result/contract/ActivityResultContracts
 *  - Articles:
 *      - https://medium.com/@ajinkya.kolkhede1/requesting-runtime-permissions-using-new-activityresult-api-cb6116551f00
 *      - https://adambennett.dev/2020/03/introducing-the-activity-result-apis/
 *
 * Things to keep in mind:
 * - When to register contracts?
 *      BAD: registering contracts in user callbacks, like in setOnClickListener.
 *          Don't do this, because it can crash the app immediately or when recreating.
 *      GOOD: registering contracts in fields or during onCreate
 * - Many use cases are covered by predefined Contracts, so make sure to take a look before making your own.
 *      https://developer.android.com/reference/androidx/activity/result/contract/ActivityResultContracts
 * - ActivityResultLauncher#launch is NOT type safe, so bee careful to pass the correct information
 *      to the #launch method, otherwise it will crash.
 *
 * TODO Show example from our app, how it was refactored.
 */
class LearnActivityResultActivity : AppCompatActivity() {
    private val activityLauncher = registerForActivityResult(StartActivityForResult()) { result ->
        if (result.resultCode == ACTIVITY_RESULT_CODE) {
            val intent = result.data
            val text = intent?.getStringExtra(EXTRA_RESULT_DATA)
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
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

    private val predefinedContract = registerForActivityResult(PickContact()) { uri ->
        Toast.makeText(this, uri?.toString(), Toast.LENGTH_SHORT).show()
        // To see proper result, you have to parse it accordingly.
    }

    private val customContractLauncher = registerForActivityResult(PickRingtone()) { uri ->
        Toast.makeText(this, uri.toString(), Toast.LENGTH_SHORT).show()
        // To see proper result, you have to parse it accordingly.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_activity_result)

        // Activity with result
        launchActivityButton.setOnClickListener {
            activityLauncher.launch(ActivityWithResult.createIntent(this))
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

        // Predefined contract
        launchPredefinedContractButton.setOnClickListener {
            predefinedContract.launch(null)
        }

        // Custom contract
        launchCustomContractButton.setOnClickListener {
            customContractLauncher.launch(RingtoneManager.TYPE_RINGTONE)
        }

        // Test from Fragment
        launchFragmentButton.setOnClickListener {

        }
    }

    companion object {
        const val ACTIVITY_RESULT_CODE = 123
        const val EXTRA_RESULT_DATA = "extra.result_data"

        fun createIntent(context: Context) = Intent(context, LearnActivityResultActivity::class.java)
    }
}