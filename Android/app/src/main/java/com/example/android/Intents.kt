package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.android.databinding.IntentsActivityBinding

class Intents : AppCompatActivity() {
    private lateinit var binding: IntentsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IntentsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar ?. setHomeButtonEnabled(true)

        binding.act01.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}