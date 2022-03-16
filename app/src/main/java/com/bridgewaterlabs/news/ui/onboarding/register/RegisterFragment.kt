package com.bridgewaterlabs.news.ui.onboarding.register

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.databinding.FragmentRegisterBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment
import com.bridgewaterlabs.news.ui.common.successregister.SuccessRegisterDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment() {
    lateinit var binding: FragmentRegisterBinding
    private val viewModel: RegisterViewModel by viewModel()
    private val privacyPolicy =
        SpannableString("I agree with Terms and Conditions an Privacy Policy")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnRegisterPassword.setOnClickListener() {
            val dialog = SuccessRegisterDialogFragment()
            dialog.show(childFragmentManager, "Success")
        }

        binding.ivBack.setOnClickListener() {
            findNavController().navigateUp()
        }

        linkTermAndConditions()
        linkPrivacyPolicy()

        return binding.root
    }

    fun linkTermAndConditions() {
        val span = object : ClickableSpan() {
            override fun onClick(p0: View) {
//                val url = "https://google.rs/"
//            CustomTabsIntent.Builder()
//                .build()
//                .launchUrl(this, Uri.parse(url))
//
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.parseColor("#3AA6DD")
                ds.isUnderlineText = false
            }
        }

        privacyPolicy.setSpan(span, 13, 33, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.privacyPolicy.text = privacyPolicy
        binding.privacyPolicy.movementMethod = LinkMovementMethod.getInstance()
    }

    fun linkPrivacyPolicy() {
        val span = object : ClickableSpan() {
            override fun onClick(p0: View) {
//          val url = "https://google.rs/"
//            CustomTabsIntent.Builder()
//                .build()
//                .launchUrl(this, Uri.parse(url))
//
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.parseColor("#3AA6DD")
                ds.isUnderlineText = false
            }
        }
        privacyPolicy.setSpan(span, 37, 51, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.privacyPolicy.text = privacyPolicy
        binding.privacyPolicy.movementMethod = LinkMovementMethod.getInstance()
    }
}
