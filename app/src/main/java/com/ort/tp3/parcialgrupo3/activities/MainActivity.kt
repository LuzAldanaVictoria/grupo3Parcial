package com.ort.tp3.parcialgrupo3.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.ort.tp3.parcialgrupo3.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var nav_view : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this,R.id.navhost)
        drawerLayout = findViewById(R.id.drawer_layout)
        nav_view = findViewById(R.id.nav_view)
        nav_view.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
    }

}