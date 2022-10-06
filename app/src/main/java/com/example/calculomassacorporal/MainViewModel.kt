package com.example.calculomassacorporal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    var resultado = 0.00
    var resultadoIMC = ""

    private val _peso: MutableLiveData<Double> by lazy{
        MutableLiveData<Double>()
    }
    val peso: LiveData<Double> = _peso

    private val _altura: MutableLiveData<Double> by lazy{
        MutableLiveData<Double>()
    }
    val altura: LiveData<Double> = _altura

    private val _final: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    val final: LiveData<String> = _final

    fun setFinal(value: String){
        _final.setValue(value)
    }

    fun setPeso(value: Double){
        _peso.setValue(value)
    }

    fun setAltura(value: Double){
        _altura.setValue(value)

    }

    fun calcularIMC(){
        if(peso.value != null && altura.value!= null){
            resultado = peso.value!! / (altura.value!! * altura.value!!)
        }

    }

    fun dizerIMC(){
        if (resultado < 0.0016){
            resultadoIMC = "Magreza grave"
            setFinal(resultadoIMC)
        } else if (resultado < 0.0017){
            resultadoIMC = "Magreza moderada"
            setFinal(resultadoIMC)
        }else if (resultado < 0.0018){
            resultadoIMC = "Magreza leve"
            setFinal(resultadoIMC)
        }else if (resultado < 0.0025){
            resultadoIMC = "Saudável"
            setFinal(resultadoIMC)
        }else if (resultado < 0.0030){
            resultadoIMC = "sobrepeso"
            setFinal(resultadoIMC)
        } else if (resultado < 0.0035){
            resultadoIMC = "Obesidade Grau I"
            setFinal(resultadoIMC)
        }else if (resultado < 0.0040){
            resultadoIMC = "Obesidade Grau II (severa)"
            setFinal(resultadoIMC)
        } else if (resultado > 0.0040){
            resultadoIMC = "Obesidade Grau III (mórbida)"
            setFinal(resultadoIMC)
        }
    }
}