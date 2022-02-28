package com.bridgewaterlabs.news.ui.onboarding.forgotpassword

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.databinding.FragmentForgotpasswordBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment

class ForgotPasswordFragment : BaseFragment() {

    private lateinit var binding: FragmentForgotpasswordBinding
    lateinit var viewModel: ForgotPasswordViewModel

    private val action = ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToResetPasswordFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotpasswordBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ForgotPasswordViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.isChecked.observe(viewLifecycleOwner) {
            binding.btnForgotPassword.isEnabled = it
        }

        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.isChecked.value = true
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.btnForgotPassword.setOnClickListener() {
            findNavController().navigate(action)
        }

        binding.ivBack.setOnClickListener() {
            findNavController().navigateUp()
        }
        return binding.root
    }
}
