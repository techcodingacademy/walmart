package com.presentation.countrylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.model.Country
import com.domain.repository.CountryRepository
import com.util.Resource
import kotlinx.coroutines.launch

class CountryListViewModel(
    private val repository: CountryRepository
) : ViewModel() {

    private val _countriesResult = MutableLiveData<Resource<List<Country>>>()
    val countriesResult: LiveData<Resource<List<Country>>> = _countriesResult

    fun loadCountries() {
        viewModelScope.launch {
            when (val result = repository.fetchAllCountries()) {
                is Resource.Success -> {
                    _countriesResult.value = Resource.Success(result.data)
                }

                is Resource.Error -> {
                    _countriesResult.value = Resource.Error(result.message, result.throwable)
                }

                Resource.Loading -> {
                    _countriesResult.value = Resource.Loading
                }
            }
        }
    }
}