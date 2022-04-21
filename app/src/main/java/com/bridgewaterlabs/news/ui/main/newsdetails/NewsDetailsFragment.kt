package com.bridgewaterlabs.news.ui.main.newsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bridgewaterlabs.news.databinding.FragmentNewsDetailsBinding
import com.bridgewaterlabs.news.model.NewsModel
import com.bridgewaterlabs.news.ui.main.home.HomeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsDetailsFragment : Fragment() {

    private val viewModel: NewsDetailsViewModel by viewModel()
    lateinit var binding: FragmentNewsDetailsBinding
    private val args: NewsDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)

        Toast.makeText(context, "you passed number ${args.position} here ", Toast.LENGTH_SHORT)
            .show()

//        initNews(args.position)
        bindingBackButton()

        return binding.root
    }

//    fun initNews(position: Int) {
//        viewModel.getNewsDetails(position)
//    }

    fun bindingBackButton() {
        binding.ivBack.setOnClickListener() {
            findNavController().navigateUp()
        }
    }

//    fun initfakeNews(position: Int): NewsModel {
//        val models = HomeFragment()
//        val list: List<NewsModel> = models.initFakeNews()
//        return list[position]
//    }
}
