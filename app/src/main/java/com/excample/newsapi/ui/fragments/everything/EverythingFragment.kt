package com.excample.newsapi.ui.fragments.everything

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.excample.newsapi.R
import com.excample.newsapi.base.BaseFragment
import com.excample.newsapi.databinding.FragmentEverythingBinding
import com.excample.newsapi.ui.adapters.NewsAdapter
import com.excample.newsapi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EverythingFragment :
    BaseFragment<FragmentEverythingBinding, EverythingViewModel>(R.layout.fragment_everything) {

    override val viewModel: EverythingViewModel by viewModels()
    override val binding by viewBinding(FragmentEverythingBinding::bind)
    private val adapterEverything = NewsAdapter()

    override fun initialize() = with(binding.recyclerView) {
        adapter = adapterEverything
    }

    override fun setupSubscribes() {
        subscribeToEverything()
    }

    private fun subscribeToEverything() {
        viewModel.fetchNews("bitcoin").observe(viewLifecycleOwner) {
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