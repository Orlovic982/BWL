package com.bridgewaterlabs.news.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bridgewaterlabs.news.databinding.ViewNewsBinding
import com.bridgewaterlabs.news.models.NewsModel

class HomeRecycleAdapter(var news:List<NewsModel>):RecyclerView.Adapter<HomeRecycleAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding:ViewNewsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
      return NewsViewHolder(ViewNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.binding.
        apply {
            newsTitle.text=news[position].title
            newsBody.text=news[position].body

        }
    }

    override fun getItemCount(): Int {
     return news.size
    }


}