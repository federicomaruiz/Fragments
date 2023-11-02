package com.fede.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
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
        binding.fabInitialNext.setOnClickListener { navigateNext() } // pongo el boton a la escucha de click que llame a la funcion navigate
    }

    private fun navigateNext() {
        val secondFragment = InitialSecondFragment() // Creo una instancia del segundo fragmento
        val transaction = parentFragmentManager.beginTransaction() // Creo e inicio la transaccion
        transaction.setReorderingAllowed(true) // EL SO re-ordena optimizacion
        transaction.replace(R.id.fcv_test, secondFragment) // primer parametro id del container segundo al fragmento que quiero ir
        transaction.setTransition(TRANSIT_FRAGMENT_FADE) // efecto cuando deja la pantalla
        transaction.addToBackStack(null) // Puedo regresar atras guarda el fragmento en la cola a
        transaction.commit() // efectuar cambios

    }

}