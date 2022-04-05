package com.bridgewaterlabs.news.ui.main.newsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bridgewaterlabs.news.databinding.FragmentNewsDetailsBinding

class NewsDetails : Fragment() {

    lateinit var viewModel: NewsDetailsViewModel
    lateinit var binding: FragmentNewsDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }
}
