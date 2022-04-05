package com.bridgewaterlabs.news.ui.main.privacysettings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.R
import com.bridgewaterlabs.news.databinding.FragmentPrivacySettingsBinding

class PrivacySettingsFragment : Fragment() {

lateinit var binding: FragmentPrivacySettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentPrivacySettingsBinding.inflate(inflater,container,false)
        binding.lifecycleOwner=viewLifecycleOwner

        setupBackButton()



        return binding.root
    }

    fun setupBackButton(){
        binding.ivBack.setOnClickListener() {
            findNavController().navigateUp()
        }
    }




}