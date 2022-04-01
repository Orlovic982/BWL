package com.bridgewaterlabs.news.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bridgewaterlabs.news.R
import com.bridgewaterlabs.news.databinding.FragmentHomeBinding
import com.bridgewaterlabs.news.models.NewsModel
import com.bridgewaterlabs.news.ui.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val viewmodel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = viewLifecycleOwner

        bindAdapter()
        bingSlideMenu()

        return binding.root
    }

    private fun bingSlideMenu() {
        binding.btnSlideMenu.setOnClickListener() { v ->
            (activity as MainActivity).openCloseNavigationDrawer(v)
        }
    }

    private fun initFakeNews(): List<NewsModel> {
        return mutableListOf(
            NewsModel(
                "Title 1",
                R.string.lorem_ipsum.toString()
            ),
            NewsModel(
                "Title 2",
                R.string.lorem_ipsum.toString()
            ),
            NewsModel(
                "Title 3",
                R.string.lorem_ipsum.toString()
            ),
            NewsModel(
                "Title 4",
                R.string.lorem_ipsum.toString()
            ),
            NewsModel(
                "Title 5",
                R.string.lorem_ipsum.toString()
            ),
            NewsModel(
                "Title 6",
                R.string.lorem_ipsum.toString()
            ),
            NewsModel(
                "Title 6",
                R.string.lorem_ipsum.toString()
            ),
            NewsModel(
                "Title 7",
                R.string.lorem_ipsum.toString()
            ),

        )
    }

    private fun bindAdapter() {
        val adapter = HomeAdapter(initFakeNews())
        binding.recycleView.adapter = adapter
        val topMargin = AdapterDecoration(30)
        binding.recycleView.addItemDecoration(topMargin)
        binding.recycleView.layoutManager = LinearLayoutManager(context)
    }
}
