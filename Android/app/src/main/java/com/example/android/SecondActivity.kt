package com.example.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.databinding.Activity2Binding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: Activity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.act3.setOnClickListener {
            Intent(this, Activity3::class.java).also{
                startActivity(it)
            }
        }
        binding.backbtn.setOnClickListener {
            finish()
        }
    }
}