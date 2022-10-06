package com.example.calculomassacorporal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.calculomassacorporal.databinding.FragmentTelaResultadoBinding

class TelaResultadoFragment : Fragment() {


    val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentTelaResultadoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTelaResultadoBinding.inflate(inflater, container, false)
        val view = binding.root

        setup()
        return view

    }

    private fun setup() {
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.final.observe(viewLifecycleOwner){
            binding.tvResultado.text = "O Resultado foi:${String.format("%.6f", viewModel.resultado)} \n você está classificado como ${it}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}