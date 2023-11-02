package com.fede.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fede.fragments.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var _binding : FragmentWelcomeBinding

    private val binding: FragmentWelcomeBinding get() = _binding

    private var name:String? = null // Declaro mis variable nulable para luego guardar lo que llega por argumento
    private var email:String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater)
        return binding.root
    }

    /*
    * Funcion para recuperar los argumentos
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(requireArguments().containsKey("name")){  // Si hay algun argumento que contenga la clave "name"
            name = requireArguments().getString("name") // guardalo en la variable name
        }
        if(requireArguments().containsKey("email")){
            email = requireArguments().getString("email")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvName.text = name
        binding.tvEmail.text = email
    }

}