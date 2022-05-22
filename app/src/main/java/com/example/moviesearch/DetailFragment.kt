package com.example.moviesearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getExtraFilm = arguments?.get("film") as FilmDataClass
        setStuff(view, getExtraFilm)
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

}