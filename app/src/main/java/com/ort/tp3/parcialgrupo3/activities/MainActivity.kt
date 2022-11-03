package com.ort.tp3.parcialgrupo3.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
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
    lateinit var appBarConfiguration: AppBarConfiguration   //BARRA SUPERIOR


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val objectIntent : Intent = intent
        var user = objectIntent.getStringExtra("Usuario")
        Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show()

        navController = Navigation.findNavController(this,R.id.navhost)
        drawerLayout = findViewById(R.id.drawer_layout)
        nav_view = findViewById(R.id.nav_view)
        nav_view.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)

        //NAVIGATION UP BUTTON (FLECHITA PARA ATRAS SIEMPRE VUELVE AL HOME)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawer_layout) //SET UP CON ID DRAWER DEL FRAGMENT
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout) //SET UP CON ID DRAWER DEL FRAGMENT

        //DRAWER LAYOUT
        NavigationUI.setupWithNavController(nav_view, navController) //SET UP CON ID NAV VIEW DEL FRAGMENT
    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

}