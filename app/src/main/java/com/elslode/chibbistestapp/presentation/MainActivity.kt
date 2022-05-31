package com.elslode.chibbistestapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.elslode.chibbistestapp.R
import com.elslode.chibbistestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //TODO: попробуй потом переделать на FragmentContainerView - сейчас стоит просто fragment
       val navController = findNavController(R.id.fragment_container)
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}