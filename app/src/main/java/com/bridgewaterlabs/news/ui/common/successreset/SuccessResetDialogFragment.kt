package com.bridgewaterlabs.news.ui.common.successreset

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.R
import com.bridgewaterlabs.news.databinding.DialogFragmentSuccesResetBinding
import com.bridgewaterlabs.news.databinding.FragmentResetpasswordBinding

class SuccessResetDialogFragment : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogFragmentSuccesResetBinding.inflate(inflater, container, false)
        return binding.root

    }
}
