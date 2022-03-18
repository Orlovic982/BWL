package com.bridgewaterlabs.news.ui.common.successregister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bridgewaterlabs.news.databinding.DialogFragmentSuccesRegisterBinding

class SuccessRegisterDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogFragmentSuccesRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }
}
