package com.bridgewaterlabs.news.ui.main.notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bridgewaterlabs.news.R
import com.bridgewaterlabs.news.databinding.FragmentNotificationsBinding
import com.bridgewaterlabs.news.databinding.ViewNewsBinding

class NotificationsFragment : Fragment() {

    lateinit var binding: FragmentNotificationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentNotificationsBinding.inflate(inflater,container,false)

        return binding.root


    }


}