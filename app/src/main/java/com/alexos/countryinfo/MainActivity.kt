package com.alexos.countryinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

                try{

                val countries = restCountiesApi.getCountryName(counrtyName)
                val counrty = countries[0]

                binding.countryNameTextView.text = counrty.name
                binding.capitalTextView.text = counrty.capital
                binding.populationTextView.text = formatNumber(counrty.population)
                binding.areaTextView.text = formatNumber(counrty.area)
                binding.languagesTextView.text = languagesToString(counrty.languages)

                loadSvg(binding.imageView, counrty.flag)

                binding.resultLayout.visibility = View.VISIBLE
                binding.statusLayout.visibility = View.INVISIBLE

            } catch (e: Exception) {

                binding.statusTextView.text = "Couldn't find country ${counrtyName}"
                binding.statusImageView.setImageResource(R.drawable.ic_baseline_error_24)
                binding.resultLayout.visibility = View.INVISIBLE
                binding.statusLayout.visibility = View.VISIBLE

            }

            }

        }
    }

}