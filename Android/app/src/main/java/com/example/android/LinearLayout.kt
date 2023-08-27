package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.databinding.LinearLayoutBinding

class LinearLayout : AppCompatActivity() {
    private lateinit var binding: LinearLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = LinearLayoutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.next.setOnClickListener {
            Intent(this, ConstraintLayout::class.java).also {
                startActivity(it)
            }
        }

    }
}