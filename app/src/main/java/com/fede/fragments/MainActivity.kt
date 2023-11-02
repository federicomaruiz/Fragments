package com.fede.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fede.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding: ActivityMainBinding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var myInitialFragment = InitialFragment()
           val transaction =  supportFragmentManager.beginTransaction()
           transaction.add(binding.fcvTest.id, myInitialFragment)
           transaction.commit()


    }
}