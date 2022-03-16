package com.bridgewaterlabs.news.ui.onboarding.resetpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.databinding.FragmentResetpasswordBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment
import com.bridgewaterlabs.news.ui.common.successreset.SuccessResetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResetPasswordFragment : BaseFragment() {

    private lateinit var binding: FragmentResetpasswordBinding
    private val viewModel: ResetPasswordViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResetpasswordBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel

        binding.btnResetPassword.setOnClickListener() {
            val dialog = SuccessResetDialogFragment()
            dialog.show(childFragmentManager, "Success")
        }

        binding.ivBack.setOnClickListener() {
            findNavController().navigateUp()
        }
        return binding.root
    }
}
