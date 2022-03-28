package com.bridgewaterlabs.news.ui.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bridgewaterlabs.news.R
import com.bridgewaterlabs.news.databinding.ActivityMainBinding
import com.bridgewaterlabs.news.databinding.ActivityMainBindingImpl

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_main_fragment) as NavHostFragment
        navController= navHostFragment.findNavController()

        binding.bottomNavigation.setupWithNavController(navController)

        binding.bottomNavigation.getOrCreateBadge(R.id.notificationsFragment).apply {
            number=10
            isVisible=true
            backgroundColor= Color.parseColor("#3AA6DD")
        }



    }
}