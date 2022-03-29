package com.bridgewaterlabs.news.ui.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bridgewaterlabs.news.R
import com.bridgewaterlabs.news.databinding.ActivityMainBinding
import com.bridgewaterlabs.news.databinding.ActivityMainBindingImpl
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_main_fragment) as NavHostFragment
        navController= navHostFragment.findNavController()

        val drawerLayout: DrawerLayout=binding.navDrawerMenu
        val navigationView:NavigationView=binding.navView


        binding.navView.setupWithNavController(navController)



    }


}

