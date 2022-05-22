package com.example.moviesearch

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var topbar : MaterialToolbar
    private lateinit var bottomBar : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        topBottomBarInit()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, MainFragment())
            .addToBackStack(null)
            .commit()
    }

    fun topBottomBarInit(){
        topbar = findViewById(R.id.top_menu)
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

        bottomBar = findViewById(R.id.lower_menu)
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

    fun launchDetailsFragment(film: FilmDataClass) {
        val bundle = Bundle()

        bundle.putParcelable("film", film)
        val fragment = DetailFragment()
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        AlertDialog.Builder(ContextThemeWrapper(this, R.style.DialogNew))
            .setTitle(R.string.close)
            .setIcon(R.drawable.ic_baseline_warning_24)
            .setPositiveButton(R.string.yes) { _, _ ->
                finish()
            }
            .setNegativeButton(R.string.no) { _, _ ->

            }
            .show()
    }

}