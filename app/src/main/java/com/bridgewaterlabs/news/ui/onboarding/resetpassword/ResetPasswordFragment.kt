package com.bridgewaterlabs.news.ui.onboarding.resetpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bridgewaterlabs.news.databinding.FragmentResetpasswordBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment
import com.bridgewaterlabs.news.ui.common.successreset.SuccessResetDialogFragment

class ResetPasswordFragment : BaseFragment() {

    private lateinit var binding: FragmentResetpasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentResetpasswordBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnResetPassword.setOnClickListener(){


            var dialog = SuccessResetDialogFragment()
            dialog.show(childFragmentManager,"Success")
        }


        return binding.root


    }
}