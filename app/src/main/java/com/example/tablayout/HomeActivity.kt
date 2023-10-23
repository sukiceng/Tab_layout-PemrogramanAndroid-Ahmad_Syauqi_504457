package com.example.tablayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.tablayout.databinding.HomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: HomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.logout -> {
                val intentGoHome = Intent(this, MainActivity::class.java)
                startActivity(intentGoHome)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}