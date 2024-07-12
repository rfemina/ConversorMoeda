package com.flashlight.conversormoeda

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.flashlight.conversormoeda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonDolar.setOnClickListener {
            if (binding.editValor.text.toString().isNotEmpty()) {
                convertendoDolar()
            } else {
                mensagemErro()
            }
        }

        binding.buttonEuro.setOnClickListener {
            if (binding.editValor.text.toString().isNotEmpty()) {
                convertendoEuro()
            } else {
                mensagemErro()
            }
        }

        binding.buttonLibra.setOnClickListener {
            if (binding.editValor.text.toString().isNotEmpty()) {
                convertendoLibra()
            } else {
                mensagemErro()
            }
        }

        binding.buttonPeso.setOnClickListener {
            if (binding.editValor.text.toString().isNotEmpty()) {
                convertendoPeso()
            } else {
                mensagemErro()
            }
        }
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    private fun convertendoDolar() {
        var valorEntrada: Double = binding.editValor.text.toString().trim().toDouble()
        var valorSaida = String.format("%.2f", valorEntrada * 0.18).trim()
        binding.textConvertido.text = "$valorSaida $"
        binding.textObs.text = "OBS: Convertido para o dólar americano \n" +
                "Cotação do dia 12/07/2024"
        Toast.makeText(this, "Valor alterado com sucesso", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    private fun convertendoEuro() {
        var valorEntrada: Double = binding.editValor.text.toString().trim().toDouble()
        var valorSaida = String.format("%.2f", valorEntrada * 0.17).trim()
        binding.textConvertido.text = "$valorSaida €"
        binding.textObs.text = "OBS: Convertido para o euro \n" +
                "Cotação do dia 12/07/2024"
        Toast.makeText(this, "Valor alterado com sucesso", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    private fun convertendoLibra() {
        var valorEntrada: Double = binding.editValor.text.toString().trim().toDouble()
        var valorSaida = String.format("%.2f", valorEntrada * 0.14).trim()
        binding.textConvertido.text = "$valorSaida £"
        binding.textObs.text = "OBS: Convertido para a libra esterlina \n " +
                "Cotação do dia 12/07/2024"
        Toast.makeText(this, "Valor alterado com sucesso", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    private fun convertendoPeso() {
        var valorEntrada: Double = binding.editValor.text.toString().trim().toDouble()
        var valorSaida = String.format("%.2f", valorEntrada * 167.66).trim()
        binding.textConvertido.text = "$ $valorSaida"
        binding.textObs.text = "OBS: Convertido para o peso argentino \n" +
                "Cotação do dia 12/07/2024"
        Toast.makeText(this, "Valor alterado com sucesso", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    private fun mensagemErro() {
        binding.editValor.setText("")
        Toast.makeText(this, "Valor incorreto, insira um numero", Toast.LENGTH_SHORT).show()
    }

}