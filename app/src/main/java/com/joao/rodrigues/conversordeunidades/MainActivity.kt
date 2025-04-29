package com.joao.rodrigues.conversordeunidades

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.joao.rodrigues.conversordeunidades.databinding.ActivityMainBinding
import com.joao.rodrigues.conversordeunidades.model.ConverterViewModel
import com.joao.rodrigues.conversordeunidades.model.UnitType

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = ConverterViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinners()
        setupConvertButton()
    }

    private fun setupSpinners() {
        val unitTypes = UnitType.entries.map { it.displayName }

        val adapter = ArrayAdapter(
            this,
            R.layout.spinner_item,
            unitTypes
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        binding.spinnerFromUnit.adapter = adapter
        binding.spinnerToUnit.adapter = adapter

        binding.spinnerFromUnit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewModel.setFromUnit(UnitType.entries[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.spinnerToUnit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewModel.setToUnit(UnitType.entries[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setupConvertButton() {
        binding.buttonConvert.setOnClickListener {
            val inputValue = binding.editTextValue.text.toString()

            if (inputValue.isBlank()) {
                Toast.makeText(this, getString(R.string.error_empty_value), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val value = inputValue.toDouble()
                val result = viewModel.convert(value)

                val fromUnit = viewModel.getFromUnit().displayName
                val toUnit = viewModel.getToUnit().displayName

                binding.textViewResult.text = getString(
                    R.string.result_format,
                    value,
                    fromUnit,
                    result,
                    toUnit
                )
            } catch (e: NumberFormatException) {
                Toast.makeText(this, getString(R.string.error_invalid_number), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
