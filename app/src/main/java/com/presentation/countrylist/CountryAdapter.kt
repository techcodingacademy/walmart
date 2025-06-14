package com.presentation.countrylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.domain.model.Country
import com.example.demoapp.databinding.ItemCountryBinding

class CountryAdapter(private val countries: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCountryBinding.inflate(inflater, parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.country = countries[position]
    }

    override fun getItemCount(): Int = countries.size
}