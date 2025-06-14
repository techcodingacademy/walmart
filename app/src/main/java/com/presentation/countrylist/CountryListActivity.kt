package com.presentation.countrylist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.data.remote.RetrofitInstance
import com.data.repository.CountryRepositoryImpl
import com.example.demoapp.databinding.ActivityCountryListBinding
import com.util.DefaultStringProvider
import com.util.Resource

class CountryListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountryListBinding
    private lateinit var viewModel: CountryListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCountryListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val stringProvider = DefaultStringProvider(this)
        val apiService = RetrofitInstance.api
        val repository = CountryRepositoryImpl(apiService, stringProvider)
        val factory = CountryListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[CountryListViewModel::class.java]

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.countriesResult.observe(this) { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                    binding.errorText.visibility = View.GONE
                }

                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.errorText.visibility = View.GONE

                    val adapter = CountryAdapter(result.data)

                    binding.recyclerView.adapter = adapter
                }

                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = result.message
                }
            }
        }

        viewModel.loadCountries()
    }
}