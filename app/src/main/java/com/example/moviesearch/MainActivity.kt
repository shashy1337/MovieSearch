package com.example.moviesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initButtons()
    }

    fun initButtons(){
        val buttonMenu = findViewById<Button>(R.id.button_menu)
        val buttonFav = findViewById<Button>(R.id.button_fav)
        val buttonLater = findViewById<Button>(R.id.button_later)
        val buttonCompil = findViewById<Button>(R.id.button_compilation)
        val buttonSettings = findViewById<Button>(R.id.button_settings)

        buttonMenu.setOnClickListener {
            Toast.makeText(this, R.string.button_menu, Toast.LENGTH_SHORT).show()
        }

        buttonFav.setOnClickListener {
            Toast.makeText(this, R.string.button_fav,  Toast.LENGTH_SHORT).show()
        }

        buttonLater.setOnClickListener {
            Toast.makeText(this, R.string.button_later, Toast.LENGTH_SHORT).show()
        }

        buttonCompil.setOnClickListener {
            Toast.makeText(this, R.string.button_compilation, Toast.LENGTH_SHORT).show()
        }

        buttonSettings.setOnClickListener {
            Toast.makeText(this, R.string.button_settings, Toast.LENGTH_SHORT).show()
        }

    }
}