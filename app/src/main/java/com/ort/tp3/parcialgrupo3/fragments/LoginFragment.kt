package com.ort.tp3.parcialgrupo3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ort.tp3.parcialgrupo3.R


class LoginFragment : Fragment() {
    private lateinit var userEditText: EditText
    private lateinit var passwordEditText: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val continueButton = view.findViewById<Button>(R.id.btnLogIn)
        userEditText = view.findViewById(R.id.txtLogInEmail)
        passwordEditText = view.findViewById(R.id.txtLogInPass)

        continueButton.setOnClickListener {

            navController.navigate(
                LoginFragmentDirections.actionLoginFragmentToHomeFragment(
                    userEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            )
        }
    }
}