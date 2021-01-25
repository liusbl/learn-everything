package com.learn.everything.activity_result

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.CreateDocument
import androidx.fragment.app.Fragment
import com.learn.everything.R
import kotlinx.android.synthetic.main.fragment_create_document.*

// By the way, did you know that Fragment provides constructor with layout parameter?
class CreateDocumentFragment : Fragment(R.layout.fragment_create_document) {
    private val predefinedContract = registerForActivityResult(CreateDocument()) { uri ->
        Toast.makeText(requireActivity(), uri?.toString(), Toast.LENGTH_SHORT).show()
        // To see proper result, you have to parse it accordingly.
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        predefinedContractButton.setOnClickListener {
            predefinedContract.launch("name.txt")
        }
    }

    companion object {
        fun newInstance() = CreateDocumentFragment()
    }
}