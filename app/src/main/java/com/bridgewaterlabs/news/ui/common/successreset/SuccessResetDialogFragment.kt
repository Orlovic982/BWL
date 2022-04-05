package com.bridgewaterlabs.news.ui.common.successreset

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bridgewaterlabs.news.databinding.DialogFragmentSuccesResetBinding
import com.bridgewaterlabs.news.ui.main.MainActivity

class SuccessResetDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogFragmentSuccesResetBinding.inflate(inflater, container, false)

        binding.btnGoNext.setOnClickListener {
            Intent(requireContext(), MainActivity::class.java).also {
                startActivity(it)
            }
        }
        return binding.root
    }
}
