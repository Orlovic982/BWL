package com.bridgewaterlabs.news.ui.common.successregister

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bridgewaterlabs.news.databinding.DialogFragmentSuccesRegisterBinding
import com.bridgewaterlabs.news.ui.main.MainActivity

class SuccessRegisterDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogFragmentSuccesRegisterBinding.inflate(inflater, container, false)
        binding.btnGonext.setOnClickListener {
            Intent(requireContext(), MainActivity::class.java).also {
                startActivity(it)
            }

        }

        return binding.root
    }
}
