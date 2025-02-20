package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.myapplication.Classes.CadastroViewModel
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_pergunta1.*


class pergunta1 : Fragment() {

    private lateinit var cadastroViewModel: CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.let {
            cadastroViewModel = ViewModelProviders.of(it).get(CadastroViewModel::class.java)
        }
        return inflater.inflate(R.layout.fragment_pergunta1, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            prox1.setOnClickListener {

                if (a1.isChecked) {
                    cadastroViewModel.addPontos(0)
                }
                if (b1.isChecked) {
                    cadastroViewModel.addPontos(2)
                }
                if (c1.isChecked) {
                    cadastroViewModel.addPontos(3)
                }
                if (d1.isChecked) {
                    cadastroViewModel.addPontos(4)
                }


                var id: Int = radioGroup.checkedRadioButtonId
                if (id != -1) {
                    val radioButton: RadioButton = view!!.findViewById(id)
                    Toast.makeText(
                        getActivity(), "Selecionou : ${radioButton.text}",
                        Toast.LENGTH_SHORT
                    ).show()

                    findNavController()
                        .navigate(R.id.action_pergunta1_to_pergunta2)
                } else {
                    Toast.makeText(
                        getActivity(), "Por favor, selecione uma opção",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }







