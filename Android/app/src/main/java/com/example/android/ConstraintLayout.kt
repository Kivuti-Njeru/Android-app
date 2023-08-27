package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.databinding.ConstraintLayoutBinding

class ConstraintLayout : AppCompatActivity() {

    private lateinit var binding: ConstraintLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ConstraintLayoutBinding.inflate(layoutInflater)
        setContentView(R.layout.constraint_layout)

        binding.back.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}