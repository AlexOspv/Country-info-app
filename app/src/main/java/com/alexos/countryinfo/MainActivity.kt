package com.alexos.countryinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.alexos.countryinfo.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val counrtyName = binding.countryNameEditText.text.toString()

            lifecycleScope.launch {

                val countries = restCountiesApi.getCountryName(counrtyName)
                val counrty = countries[0]

                binding.countryNameTextView.text = counrty.name
                binding.capitalTextView.text = counrty.capital
                binding.populationTextView.text = counrty.population.toString()
                binding.areaTextView.text = counrty.area.toString()
                binding.languagesTextView.text = counrty.languages.toString()

            }

        }
    }
}