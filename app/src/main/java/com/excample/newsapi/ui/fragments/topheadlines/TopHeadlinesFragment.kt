package com.excample.newsapi.ui.fragments.topheadlines

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.excample.newsapi.R
import com.excample.newsapi.base.BaseFragment
import com.excample.newsapi.databinding.FragmentTopHeadlinesBinding
import com.excample.newsapi.ui.adapters.NewsAdapter
import com.excample.newsapi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopHeadlinesFragment :
    BaseFragment<FragmentTopHeadlinesBinding, TopHeadlinesViewModel>(R.layout.fragment_top_headlines) {

    override val viewModel: TopHeadlinesViewModel by viewModels()
    override val binding by viewBinding(FragmentTopHeadlinesBinding::bind)
    private val adapterEverything = NewsAdapter()

    override fun initialize() = with(binding.recyclerView) {
        adapter = adapterEverything
    }

    override fun setupSubscribes() {
        subscribeToTopHeadlines()
    }

    private fun subscribeToTopHeadlines() {
        viewModel.fetchNews("top-headlines").observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    it.data?.let {
                        adapterEverything.submitList(it.articles)
                    }
                }
            }
        }
    }
}