package com.domain.repository

import com.domain.model.Country
import com.util.Resource

interface CountryRepository {
    suspend fun fetchAllCountries(): Resource<List<Country>>
}