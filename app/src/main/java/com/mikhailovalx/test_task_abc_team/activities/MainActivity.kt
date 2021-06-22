package com.mikhailovalx.test_task_abc_team.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mikhailovalx.test_task_abc_team.R
import com.mikhailovalx.test_task_abc_team.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initialization()
    }

    private fun initialization() {
        // bottom menu
        val bottomMenu: BottomNavigationView = binding.bottomNavigationView
        navController = findNavController(R.id.fragment)
        bottomMenu.setupWithNavController(navController)

        // titles
        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.menuFragment,
                R.id.rulesFragment,
                R.id.playersFragment,
                R.id.galleryFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfig)

        // bottom menu visibility
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.menuFragment) {
                bottomMenu.visibility = View.INVISIBLE
            } else {
                bottomMenu.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}