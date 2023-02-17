package com.excample.newsapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.excample.newsapi.data.models.news.NewsItem
import com.excample.newsapi.databinding.ItemsNewsBinding

class NewsAdapter :
    ListAdapter<NewsItem, NewsAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemsNewsBinding) :
     RecyclerView.ViewHolder(binding.root) {
            fun onBind(item: NewsItem) {
                Glide.with(binding.imgHeadline)
                    .load(item.urlToImage)
                    .into(binding.imgHeadline)
                binding.textTitle.text = item.source.name
                binding.textSource.text = item.title
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemsNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<NewsItem>() {
            override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}