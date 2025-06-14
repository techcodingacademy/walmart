package com.presentation.countrylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.domain.repository.CountryRepository

class CountryListViewModelFactory(
    private val repository: CountryRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountryListViewModel(repository) as T
    }
}