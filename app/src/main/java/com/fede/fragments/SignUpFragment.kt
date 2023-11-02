package com.fede.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import com.fede.fragments.databinding.FragmentInitialSecondBinding
import com.fede.fragments.databinding.FragmentSignUpBinding
import java.util.zip.Inflater

class SignUpFragment : Fragment() {

    private lateinit var _binding: FragmentSignUpBinding
    private val binding: FragmentSignUpBinding get() = _binding // privada inmutable y del mismo tipo
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFinalizar.setOnClickListener {
            val nameValue = binding.etName.text.toString().trim()
            val emailValue = binding.etEmail.text.toString().trim()

            if (nameValue.isNotEmpty() && emailValue.isNotEmpty()) {
                navigateToWelcome(nameValue, emailValue)
            } else {
                if (nameValue.isNullOrEmpty()) {
                    binding.etName.error = getString(R.string.sign_up_empty_filed_error)
                }
                if (emailValue.isNullOrEmpty()) {
                    binding.etEmail.error = getString(R.string.sign_up_empty_filed_error)
                }
            }

        }
    }

    private fun navigateToWelcome(nameValue: String, emailValue: String) {

        val bundle = Bundle() // Creo el objeto bundle para poder pasar informacion
        bundle.putString("name",nameValue) // le añadimos los strings con su clave correspondiente
        bundle.putString("email",emailValue)

        val welcomeFragment = WelcomeFragment() // declaro inicializo el fragmento
        welcomeFragment.arguments =  bundle // le asigno como argumento el Bundle que contiene la informacion

        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fcv_test, welcomeFragment)
        transaction.setReorderingAllowed(true)
        transaction.addToBackStack(null)
        transaction.setTransition(TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}