package com.example.moviesearch.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.Activitys.MainActivity
import com.example.moviesearch.AdaptersItems.FilmAdapter
import com.example.moviesearch.AdaptersItems.FilmFavouriteAdapter
import com.example.moviesearch.App.App
import com.example.moviesearch.Interfaces.RecyclerViewItems
import com.example.moviesearch.Offset.ItemOffsetDecoration
import com.example.moviesearch.R
import com.example.moviesearch.model.FilmDataClass


class FavouriteFilmsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRvFav(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite_films, container, false)
    }

    fun initRvFav(view: View){
        val adapterFav = FilmFavouriteAdapter(requireActivity() as MainActivity)
        val rvFav = view.findViewById<RecyclerView>(R.id.favRV)
        rvFav.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = adapterFav
                addItemDecoration(ItemOffsetDecoration(requireContext()))
        }
        adapterFav.items = App.instance.favList
    }
}