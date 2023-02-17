package com.excample.newsapi.ui.fragments.sources

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.excample.newsapi.R
import com.excample.newsapi.base.BaseFragment
import com.excample.newsapi.databinding.FragmentSourcesBinding
import com.excample.newsapi.ui.adapters.NewsAdapter
import com.excample.newsapi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourcesFragment :
    BaseFragment<FragmentSourcesBinding, SourcesViewModel>(R.layout.fragment_sources) {

    override val viewModel: SourcesViewModel by viewModels()
    override val binding by viewBinding(FragmentSourcesBinding::bind)
    private val adapterSources = NewsAdapter()

    override fun initialize() = with(binding.recyclerView) {
        adapter = adapterSources
    }

    override fun setupSubscribes() {
        subscribeToSources()
    }

    private fun subscribeToSources() {
        viewModel.fetchNews("sources").observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    it.data?.let {
                        adapterSources.submitList(it.articles)
                    }
                }
            }
        }
    }
}