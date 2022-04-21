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
import com.bridgewaterlabs.news.ui.main.home.HomeFragmentDirections

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

        setupSlideMenuNavigation()
    }

    fun openCloseNavigationDrawer(view: View) {
        if (binding.navDrawerMenu.isDrawerOpen(GravityCompat.START)) {
            binding.navDrawerMenu.closeDrawer(GravityCompat.START)
        } else {
            binding.navDrawerMenu.openDrawer(GravityCompat.START)
        }
    }

    fun setupSlideMenuNavigation() {
        binding.navFavorites.setOnClickListener() {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToFavoritesFragment())
            binding.navDrawerMenu.closeDrawer(GravityCompat.START)
        }
        binding.navLanguage.setOnClickListener() {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToLanguageFragment())
            binding.navDrawerMenu.closeDrawer(GravityCompat.START)
        }
        binding.navMyProfile.setOnClickListener() {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToMyProfileFragment())
            binding.navDrawerMenu.closeDrawer(GravityCompat.START)
        }

        binding.navPrivacySettings.setOnClickListener() {
            navController.navigate(
                HomeFragmentDirections.actionHomeFragmentToPrivacySettingsFragment2()
            )
            binding.navDrawerMenu.closeDrawer(GravityCompat.START)
        }
        binding.navNotificationSettings.setOnClickListener() {
            navController.navigate(
                HomeFragmentDirections.actionHomeFragmentToNotificationSettingsFragment()
            )
            binding.navDrawerMenu.closeDrawer(GravityCompat.START)
        }
    }
}
