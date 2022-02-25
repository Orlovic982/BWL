package com.bridgewaterlabs.news.ui.onboarding.resetpassword

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.databinding.FragmentResetpasswordBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment
import com.bridgewaterlabs.news.ui.common.successreset.SuccessResetDialogFragment

class ResetPasswordFragment : BaseFragment() {

    private lateinit var binding: FragmentResetpasswordBinding
    private lateinit var viewModel: ResetPasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResetpasswordBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        viewModel = ViewModelProvider(this).get(ResetPasswordViewModel::class.java)
        binding.viewmodel=viewModel

        viewModel.isChecked.observe(viewLifecycleOwner) {
            binding.btnResetPassword.isEnabled = it
        }

        binding.etNewPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.isChecked.value = true
            }
            override fun afterTextChanged(p0: Editable?) {
            }

        })


        binding.btnResetPassword.setOnClickListener() {
            var dialog = SuccessResetDialogFragment()
            dialog.show(childFragmentManager, "Success")
        }
        binding.ivBack.setOnClickListener(){
            findNavController().navigateUp()
        }
        return binding.root
    }
}
