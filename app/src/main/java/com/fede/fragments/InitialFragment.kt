package com.fede.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fede.fragments.databinding.FragmentInitialBinding

class InitialFragment : Fragment() {

    private lateinit var _binding: FragmentInitialBinding

    // me aseguro que la variable no sea null
    private val binding: FragmentInitialBinding get() = _binding // privada inmutable y del mismo tipo


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInitialBinding.inflate(inflater)
        return binding.root  // sin el _ delante por que ya esta inicializado en la linea de arriba
    }

    // metodos y logica de los fragementos van dentro de aqui!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}