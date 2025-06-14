

https://github.com/user-attachments/assets/f8b3e98f-d6c4-4317-a5c4-0341d5783608

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
<img width="551" alt="Image" src="https://github.com/user-attachments/assets/9db40aa9-152b-4a16-8f57-ee6d136bd72a" />
