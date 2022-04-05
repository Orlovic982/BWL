package com.bridgewaterlabs.news.ui.main.notificationsettings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.databinding.FragmentNotificationSettingsBinding


class NotificationSettingsFragment : Fragment() {

    lateinit var binding: FragmentNotificationSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationSettingsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        setupBackButton()

        return binding.root


    }

    fun setupBackButton() {
        binding.ivBack.setOnClickListener() {
            findNavController().navigateUp()
        }
    }


}