package com.bridgewaterlabs.news.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bridgewaterlabs.news.R
import com.bridgewaterlabs.news.databinding.FragmentHomeBinding
import com.bridgewaterlabs.news.model.NewsModel
import com.bridgewaterlabs.news.ui.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), HomeAdapter.newsListener {

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
        // bingSlideMenu()
        binding.btnSlideMenu.setOnClickListener() {
            viewmodel.getProfile()
        }

        return binding.root
    }

    private fun bingSlideMenu() {
        binding.btnSlideMenu.setOnClickListener() { v ->
            (activity as MainActivity).openCloseNavigationDrawer(v)
        }
    }

    fun initFakeNews(): List<NewsModel> {
        return mutableListOf(
            NewsModel(
                "Title 1",
                getString(R.string.lorem_ipsum)
            ),
            NewsModel(
                "Title 2",
                getString(R.string.lorem_ipsum)
            ),
            NewsModel(
                "Title 3",

                getString(R.string.lorem_ipsum)
            ),
            NewsModel(
                "Title 4",

                getString(R.string.lorem_ipsum)
            ),
            NewsModel(
                "Title 5",

                getString(R.string.lorem_ipsum)
            ),
            NewsModel(
                "Title 6",

                getString(R.string.lorem_ipsum)
            ),
            NewsModel(
                "Title 6",
                getString(R.string.lorem_ipsum)
            ),
            NewsModel(
                "Title 7",
                getString(R.string.lorem_ipsum)
            ),

        )
    }

    private fun bindAdapter() {
        val adapter = HomeAdapter(initFakeNews(), this)
        binding.recycleView.adapter = adapter
        val topMargin = AdapterDecoration(30)
        binding.recycleView.addItemDecoration(topMargin)
        binding.recycleView.layoutManager = LinearLayoutManager(context)
    }

    override fun favoritesAdd(position: Int) {
        Toast.makeText(context, "You add position: $position", Toast.LENGTH_SHORT).show()
    }

    override fun favoritesRemove(position: Int) {
        Toast.makeText(context, "You remove position: $position", Toast.LENGTH_SHORT).show()
    }

    override fun openNwsDetail(position: Int) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToNewsDetails(position)
        )
    }
}
