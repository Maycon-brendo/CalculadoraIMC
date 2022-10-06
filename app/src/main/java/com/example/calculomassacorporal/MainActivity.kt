package com.example.calculomassacorporal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.calculomassacorporal.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()

    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnCalcular.setOnClickListener{
            if(!binding.inputPeso2.text.isNullOrBlank() && !binding.inputAltura2.text.isNullOrBlank()) {
                viewModel.setPeso(binding.inputPeso2.text.toString().toDouble())
                viewModel.setAltura(binding.inputAltura2.text.toString().toDouble())
                viewModel.calcularIMC()
                viewModel.dizerIMC()
            }
        }
    }
}