package com.fede.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import com.fede.fragments.databinding.FragmentInitialBinding
import com.fede.fragments.databinding.FragmentInitialSecondBinding

class InitialSecondFragment : Fragment() {

    private lateinit var _binding: FragmentInitialSecondBinding
    private val binding: FragmentInitialSecondBinding get() = _binding // privada inmutable y del mismo tipo
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInitialSecondBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegistrate.setOnClickListener { navigateToNext() }
    }

    private fun navigateToNext() {
        val signUpFragment = SignUpFragment()
        val transaction = parentFragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.replace(R.id.fcv_test,signUpFragment)
        transaction.setTransition(TRANSIT_FRAGMENT_FADE)
        transaction.addToBackStack(null)
        transaction.commit()


    }


}