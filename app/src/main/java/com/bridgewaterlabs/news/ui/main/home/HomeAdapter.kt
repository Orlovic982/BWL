package com.bridgewaterlabs.news.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bridgewaterlabs.news.databinding.ViewNewsBinding
import com.bridgewaterlabs.news.model.NewsModel

class HomeAdapter(var news: List<NewsModel>, private val listener: newsListener) :
    RecyclerView.Adapter<HomeAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: ViewNewsBinding, listener: newsListener) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.cbFavorites.setOnClickListener() {
                if (binding.cbFavorites.isChecked) {
                    listener.favoritesAdd(adapterPosition)
                } else {
                    listener.favoritesRemove(adapterPosition)
                }
            }
            binding.etLinkNews.setOnClickListener() {
                listener.openNwsDetail(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ViewNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            listener
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.binding
            .apply {
                newsTitle.text = news[position].title
                newsBody.text = news[position].body
            }
    }

    override fun getItemCount(): Int {
        return news.size
    }

    interface newsListener {

        fun favoritesAdd(position: Int)
        fun favoritesRemove(position: Int)
        fun openNwsDetail(position: Int)
    }
}
