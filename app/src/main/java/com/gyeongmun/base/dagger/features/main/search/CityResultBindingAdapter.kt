package com.gyeongmun.base.dagger.features.main.search

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gyeongmun.base.dagger.network.response.CityResponse

@BindingAdapter(value = ["bindCityList"])
fun bindCityList(
    recyclerView: RecyclerView,
    list: List<CityResponse>?
) {
    recyclerView.adapter?.let { adapter ->
        if (adapter is CityResultAdapter) {
            adapter.apply {
                submitList(list)
            }
        }
    } ?: run {
        val adapter = CityResultAdapter()
        recyclerView.adapter = adapter
        adapter.submitList(list)
    }
}
