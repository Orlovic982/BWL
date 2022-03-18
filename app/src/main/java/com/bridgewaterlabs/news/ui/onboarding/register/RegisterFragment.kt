package com.bridgewaterlabs.news.ui.onboarding.register

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.R
import com.bridgewaterlabs.news.databinding.FragmentRegisterBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment
import com.bridgewaterlabs.news.ui.common.successregister.SuccessRegisterDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment() {
    lateinit var binding: FragmentRegisterBinding
    private val viewModel: RegisterViewModel by viewModel()
    lateinit var text1: String
    lateinit var text2: String

    lateinit var spannable: SpannableString

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
        resources.getString(R.string.app_name)
        binding.ivBack.setOnClickListener() {
            findNavController().navigateUp()
        }

        text1 = resources.getString(R.string.terms_and_conditions)
        text2 = resources.getString(R.string.privacy_policy)
        val spannable = SpannableString(
            resources.getString(
                R.string.i_agree_withterms_and_conditions_an_privacy_policy,
                text1,
                text2
            )
        )
        setHyperLink(spannable, text1, "https://www.google.rs")
        setHyperLink(spannable, text2, "https://www.facebook.com")

        return binding.root
    }

    fun setHyperLink(spannableString: SpannableString, text: String, url: String) {
        val span = setClickableSpan(url)
        spannableString?.setSpan(
            span,
            spannableString.indexOf(text),
            spannableString.indexOf(text) + text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.privacyPolicy.text = spannableString
        binding.privacyPolicy.movementMethod = LinkMovementMethod.getInstance()
    }

    fun setClickableSpan(url: String): ClickableSpan {
        val span = object : ClickableSpan() {
            override fun onClick(p0: View) {
                CustomTabsIntent.Builder()
                    .build()
                    .launchUrl(requireContext(), Uri.parse(url))
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.parseColor("#3AA6DD")
                ds.isUnderlineText = false
            }
        }
        return span
    }
}
