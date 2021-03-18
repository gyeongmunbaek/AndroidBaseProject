package com.gyeongmun.base.dagger.features.main.search

import android.os.Bundle
import android.view.View
import com.gyeongmun.base.dagger.R
import com.gyeongmun.base.dagger.base.BaseFragment
import com.gyeongmun.base.dagger.databinding.FragmentHomeBinding

class SearchFragment : BaseFragment<SearchViewModel, FragmentHomeBinding>(
    SearchViewModel::class,
    R.layout.fragment_home
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.text.observe(viewLifecycleOwner, {
            viewModel.searchCities(it)
        })
    }

    companion object {
        const val TAG = "SearchFragment"
    }
}