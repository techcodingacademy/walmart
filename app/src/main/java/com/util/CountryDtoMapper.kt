package com.util

import com.domain.model.Country
import com.domain.model.CountryDto


fun CountryDto.toDomain(): Country {
    return Country(
        name = this.name,
        region = this.region,
        code = this.code,
        capital = this.capital
    )
}
