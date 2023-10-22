package com.example.tablayout.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tablayout.HomeActivity
import com.example.tablayout.R
import com.example.tablayout.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    companion object{
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PASSWORD = "extra_password"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        val view = binding.root
        val emailInput = binding.email
        val usernameInput = binding.username
        val passwordInput = binding.password
        val register = binding.registerBtn

        register.setOnClickListener{
            val intentRegisterFragment = Intent(requireContext(), HomeActivity::class.java)
            intentRegisterFragment.putExtra(EXTRA_EMAIL, emailInput.text.toString())
            intentRegisterFragment.putExtra(EXTRA_NAME, usernameInput.text.toString())
            intentRegisterFragment.putExtra(EXTRA_PASSWORD, passwordInput.text.toString())
            startActivity(intentRegisterFragment)
        }
        return view
    }
}