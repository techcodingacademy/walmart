# Walmart Coding Assessment – Android (Kotlin)

This repository contains the implementation for the Walmart Software Engineer – Mobile (Android) coding assessment.

## Assessment Task

**Objective:**  
Build an Android application that fetches and displays a list of countries from a JSON API.

###  API Endpoint

https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json
## Features

- Fetches country list from the remote JSON endpoint
- Displays countries in a scrollable `RecyclerView`
- Shows each country's:
  - Name
  - Region
  - Code
  - Capital
- Displays a **loading indicator** while fetching data
- Handles **no internet connection** and **API failure** gracefully with user-friendly error messages
- Preserves data on screen rotation (configuration changes)
- Follows **MVVM architecture** for separation of concerns and lifecycle-aware components
