package com.example.moviesearch.Activitys

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.moviesearch.Fragments.*
import com.example.moviesearch.model.FilmDataClass
import com.example.moviesearch.R
import com.example.moviesearch.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = this.findNavController(R.id.myNavHostController)
        bottomBarInit()

    }

    fun bottomBarInit(){
        NavigationUI.setupWithNavController(binding.lowerMenu, navController)
    }

    fun launchDetailsFragment(film: FilmDataClass) {
        navController
            .navigate(
                MainFragmentDirections
                    .actionMainFragmentToDetailFragment(film))
    }

    fun launchFavouriteFragment(film : FilmDataClass){
        navController
            .navigate(
                FavouriteFilmsFragmentDirections
                    .actionFavouriteFilmsFragmentToDetailFragment(film)
            )
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        /*AlertDialog.Builder(ContextThemeWrapper(this, R.style.DialogNew))
            .setTitle(R.string.close)
            .setIcon(R.drawable.ic_baseline_warning_24)
            .setPositiveButton(R.string.yes) { _, _ ->
                finish()
            }
            .setNegativeButton(R.string.no) { _, _ ->

            }
            .show()*/
    }

}