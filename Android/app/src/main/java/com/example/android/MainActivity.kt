package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open,
            R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Android App"

        binding.navView.setNavigationItemSelectedListener { it ->
            when(it.itemId){
                R.id.item1 ->  Intent(this, Intents::class.java).also {
                    startActivity(it)
                }
                R.id.item2 -> Intent(this, Layout1::class.java ).also {
                    startActivity(it)
                }
                R.id.item3 -> Intent(this, LinearLayout::class.java).also {
                    startActivity(it)
                }
            }
            return@setNavigationItemSelectedListener true

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
