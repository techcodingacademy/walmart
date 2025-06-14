package com.domain.model

data class CountryDto(
    val capital: String,
    val code: String,
    val currency: CurrencyDto,
    val demonym: String,
    val flag: String,
    val language: LanguageDto,
    val name: String,
    val region: String
)