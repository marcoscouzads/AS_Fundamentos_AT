package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.myapplication.Classes.CadastroViewModel

import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_pergunta2.*
import kotlinx.android.synthetic.main.fragment_pergunta3.*

class pergunta3 : Fragment() {

    private lateinit var cadastroViewModel: CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pergunta3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            cadastroViewModel = ViewModelProviders.of(it).get(CadastroViewModel::class.java)
        }


        prox3.setOnClickListener {
            if (a3.isChecked) {
                cadastroViewModel.addPontos(0)
            }
            if (b3.isChecked) {
                cadastroViewModel.addPontos(1)
            }
            if (c3.isChecked) {
                cadastroViewModel.addPontos(2)
            }
            if (d3.isChecked) {
                cadastroViewModel.addPontos(4)
            }

            var id: Int = radioGroup3.checkedRadioButtonId
            if (id != -1) {
                val radioButton: RadioButton = view!!.findViewById(id)
                Toast.makeText(
                    getActivity(), "Selecionou : ${radioButton.text}",
                    Toast.LENGTH_SHORT
                ).show()



                    findNavController()
                        .navigate(R.id.action_pergunta3_to_pergunta4)
                } else {
                    Toast.makeText(
                        getActivity(), "Por favor, selecione uma opção",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }
    }

