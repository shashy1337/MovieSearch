package com.example.moviesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        topBottomBarInit()
    }

    fun topBottomBarInit(){
        val topbar = findViewById<MaterialToolbar>(R.id.top_menu)
        topbar.setNavigationOnClickListener {
            Toast.makeText(this, R.string.navigation, Toast.LENGTH_SHORT).show()
        }
        topbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.settings_top -> {
                    Toast.makeText(this, R.string.settings, Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }

                R.id.more -> {
                    Toast.makeText(this, R.string.more, Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }

                else -> return@setOnMenuItemClickListener false
            }
        }

        val bottomBar = findViewById<BottomNavigationView>(R.id.lower_menu)
        bottomBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.compillation -> {
                    Toast.makeText(this, R.string.compilation, Toast.LENGTH_SHORT).show()
                    return@setOnItemSelectedListener true
                }
                R.id.favourite -> {
                    Toast.makeText(this, R.string.fav, Toast.LENGTH_SHORT).show()
                    return@setOnItemSelectedListener true
                }
                R.id.menu -> {
                    Toast.makeText(this, R.string.menu, Toast.LENGTH_SHORT).show()
                    return@setOnItemSelectedListener true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, R.string.later, Toast.LENGTH_SHORT).show()
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener false
            }
        }
    }


}