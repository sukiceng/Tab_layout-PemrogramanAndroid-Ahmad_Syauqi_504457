package com.example.tablayout.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tablayout.MainActivity
import com.example.tablayout.R
import com.example.tablayout.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    companion object {
        private const val EXTRA_NAME = "extra_name"
        private const val EXTRA_PASSWORD = "extra_password"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        val usernameInput = binding.username
        val passwordInput = binding.password
        val login = binding.loginBtn

        login.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            if (isLoginValid(username, password)) {
                val intentLoginFragment =
                    Intent(requireContext(), MainActivity::class.java)
                intentLoginFragment.putExtra(EXTRA_NAME, username)
                intentLoginFragment.putExtra(EXTRA_PASSWORD, password)
                startActivity(intentLoginFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Username atau Password salah",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return view
    }

    private fun isLoginValid(username: String, password: String): Boolean {
        val user = arrayOf("user1", "user2", "user3")
        val passwordList = mapOf(
            user[0] to "pass1",
            user[1] to "pass2",
            user[2] to "pass3"
        )

        if (user.contains(username)) {
            val expectedPassword = passwordList[username]
            if (password == expectedPassword) {
                return true
            }
        }
        return false
    }
}