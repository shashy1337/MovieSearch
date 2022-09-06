package com.example.moviesearch.Fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.moviesearch.App.App
import com.example.moviesearch.model.FilmDataClass
import com.example.moviesearch.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getExtraFilm = arguments?.get("film") as FilmDataClass
        setStuff(view, getExtraFilm)
        initFabButtons(view, getExtraFilm)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    fun setStuff(view: View, film : FilmDataClass){

        val detailsToolBar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.details_toolbar)
        val detailsPosters = view.findViewById<ImageView>(R.id.details_poster)
        val detailsDescription = view.findViewById<TextView>(R.id.details_description)

        detailsToolBar.title = film.title
        detailsPosters.setImageResource(film.poster)
        detailsDescription.text = film.description
    }

    fun initFabButtons(view: View, film: FilmDataClass){
        val favButton = view.findViewById<FloatingActionButton>(R.id.favourite_fab)
        val shareButton = view.findViewById<FloatingActionButton>(R.id.details_fab)

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