package com.bridgewaterlabs.news.ui.main.newsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bridgewaterlabs.news.databinding.FragmentNewsDetailsBinding
import com.bridgewaterlabs.news.models.NewsModel
import com.bridgewaterlabs.news.ui.main.home.HomeFragment

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

    fun initfakeNews(position: Int): NewsModel {

        val models = HomeFragment()
        val list: List<NewsModel> = models.initFakeNews()
        return list[position]


    }

    fun setupNewsDetails(news: NewsModel) {
        binding.tvTitle.text = news.title
    }


}
