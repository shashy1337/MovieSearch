package com.example.moviesearch.Fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.moviesearch.Activitys.MainActivity
import com.example.moviesearch.App.App
import com.example.moviesearch.model.FilmDataClass
import com.example.moviesearch.R
import com.example.moviesearch.databinding.FragmentDetailsBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val filmsArgs = DetailFragmentArgs.fromBundle(requireArguments())
        setStuff(filmsArgs.film)
        initFabButtons(filmsArgs.film)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_details, container, false)
        return binding.root
    }

    fun setStuff(film : FilmDataClass){

        val detailsToolBar = binding.detailsToolbar
        val detailsPosters = binding.detailsPoster
        val detailsDescription = binding.detailsDescription

        detailsToolBar.title = film.title
        detailsPosters.setImageResource(film.poster)
        detailsDescription.text = film.description
    }

    fun initFabButtons(film: FilmDataClass){
        val favButton = binding.favouriteFab
        val shareButton = binding.detailsFab

        favButton.setOnClickListener {
            if (!film.isFavourite){
                favButton.setImageResource(R.drawable.ic_baseline_favorite_24)
                film.isFavourite = true
                App.instance.favList.add(film)
            } else{
                favButton.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                film.isFavourite = false
                App.instance.favList.remove(film)
            }
        }
        shareButton.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,
                    "See the film ${film.title} with description ${film.description}")
                type = "text/plain"
            }
            try {
                startActivity(intent)
            } catch (e : ActivityNotFoundException){
                e.printStackTrace()
            }
        }
    }
}