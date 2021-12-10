package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.Classes.CadastroViewModel
import kotlinx.android.synthetic.main.activity_resultado.*

class Resultado : AppCompatActivity() {

    private lateinit var questionarioViewModel: CadastroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        questionarioViewModel = ViewModelProviders.of(this)
            .get(CadastroViewModel::class.java)

        nav()
        dados()
    }

    private fun nav() {
        bottomNavView.setupWithNavController(
            findNavController(R.id.hostFrag)
        )
    }

    private fun dados() {

        val nome = intent.getStringExtra("nome")
        questionarioViewModel.nome.value = nome

        var resposta = intent.getIntExtra("resposta", 0)
        if (resposta <= 12) {
            var valor = "Perfil: Conservador"
            questionarioViewModel.valor = valor
        } else {
            if (resposta in 13..29) {
                var valor = "Perfil: Moderado"
                questionarioViewModel.valor = valor
            } else {
                var valor = "Perfil: Arrojado"
                questionarioViewModel.valor = valor

            }
        }
    }
}




