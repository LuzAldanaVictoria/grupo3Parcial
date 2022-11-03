package com.ort.tp3.parcialgrupo3.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.navArgs
import androidx.navigation.ui.AppBarConfiguration
import com.ort.tp3.parcialgrupo3.R
import com.ort.tp3.parcialgrupo3.utils.UserSession


class LogInActivity : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration   //BARRA SUPERIOR
    lateinit var btnLogIn: Button
    lateinit var txtLogInEmail : TextView
    lateinit var txtLogInPassword : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        btnLogIn = findViewById(R.id.btnLogIn)
        txtLogInEmail = findViewById(R.id.txtLogInEmail)
        txtLogInPassword = findViewById(R.id.txtLogInPass)



        btnLogIn.setOnClickListener {
               if (txtLogInEmail.text.toString().isNotEmpty() && txtLogInPassword.text.toString().isNotEmpty()) {
                   //setContentView.(R.layout.activity_main)
                    var email : String = txtLogInEmail.text.toString()
                   val intent : Intent = Intent(this, MainActivity::class.java)
                   intent.putExtra("Usuario", email)
                   startActivity(intent)


               } else {
                   Toast.makeText(
                       this,
                       "Debe completar todos los campos",
                       Toast.LENGTH_SHORT
                   ).show()
               }

        }

    }
}