package com.bridgewaterlabs.news.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bridgewaterlabs.news.R
import com.bridgewaterlabs.news.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_main_fragment) as
            NavHostFragment

        navController = navHost.findNavController()

        binding.navView.setupWithNavController(navController)
    }

    fun openCloseNavigationDrawer(view: View) {
        if (binding.navDrawerMenu.isDrawerOpen(GravityCompat.START)) {
            binding.navDrawerMenu.closeDrawer(GravityCompat.START)
        } else {
            binding.navDrawerMenu.openDrawer(GravityCompat.START)
        }
    }
}
