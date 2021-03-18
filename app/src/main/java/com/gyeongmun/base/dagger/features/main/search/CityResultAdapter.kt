package com.gyeongmun.base.dagger.features.main.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.gyeongmun.base.dagger.databinding.ItemCityResultBinding
import com.gyeongmun.base.dagger.network.response.CityResponse

class CityResultAdapter : ListAdapter<CityResponse, ViewHolder>(itemDiff) {

    companion object {
        const val HEADER = 0
        const val CATEGORY = 1
        const val ITEM = 2
        const val FOOTER = 3
    }

    override fun getItemViewType(position: Int): Int {
        return ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCityResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CityResultItemViewHolder(binding)
    }

    override fun onBindViewHolder(holderItem: ViewHolder, position: Int) {
        when (holderItem) {
            is CityResultItemViewHolder -> {
                holderItem.bind(getItem(position))
            }
        }
    }
}

class CityResultItemViewHolder(private val binding: ItemCityResultBinding) :
    ViewHolder(binding.root) {

    fun bind(item: CityResponse) {
        binding.tvElement.text = item.title
    }
}

val itemDiff = object : DiffUtil.ItemCallback<CityResponse>() {
    override fun areItemsTheSame(oldItem: CityResponse, newItem: CityResponse): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CityResponse, newItem: CityResponse): Boolean {
        return oldItem.title == newItem.title
    }
}
