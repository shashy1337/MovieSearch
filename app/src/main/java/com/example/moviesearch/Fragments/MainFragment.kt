package com.example.moviesearch.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.Activitys.MainActivity
import com.example.moviesearch.AdaptersItems.FilmAdapter
import com.example.moviesearch.App.App
import com.example.moviesearch.Offset.ItemOffsetDecoration
import com.example.moviesearch.R
import com.example.moviesearch.model.FilmDataClass
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

class MainFragment : Fragment() {


    private val filmDataBase = App.instance.filmDataBase
    private lateinit var filmAdapter : FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view.findViewById(R.id.recycler_view_films))
        initSearchView(view.findViewById(R.id.search_view))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    fun initRecyclerView(recyclerView: RecyclerView){

        filmAdapter = FilmAdapter(requireActivity() as MainActivity)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = filmAdapter
            addItemDecoration(ItemOffsetDecoration(requireContext()))
        }
        filmAdapter.items = filmDataBase
    }

    fun initSearchView(searchView: SearchView){
        searchView.setOnClickListener {
            searchView.isIconified = false
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText!!.isEmpty()) {
                    filmAdapter.items = filmDataBase
                    return true
                }
                val result = filmDataBase.filter {

                    it.title.toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault()))
                }
                filmAdapter.items = result
                return true
            }
        })
    }

}