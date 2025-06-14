package com.data.repository

import com.data.remote.CountryApiService
import com.domain.model.Country
import com.domain.repository.CountryRepository
import com.example.demoapp.R
import com.util.Resource
import com.util.StringProvider
import com.util.toDomain
import java.io.IOException

class CountryRepositoryImpl(
    private val apiService: CountryApiService,
    private val stringProvider: StringProvider
) : CountryRepository {

    override suspend fun fetchAllCountries(): Resource<List<Country>> {
        return try {
            val response = apiService.getAllCountries()
            if (response.isSuccessful) {
                val result = response.body()?.map { it.toDomain() } ?: emptyList()
                Resource.Success(result)
            } else {
                Resource.Error(stringProvider.getString(R.string.error_api))
            }
        } catch (e: IOException) {
            Resource.Error(stringProvider.getString(R.string.error_network), e)
        } catch (e: Exception) {
            Resource.Error(stringProvider.getString(R.string.error_unknown), e)
        }
    }
}