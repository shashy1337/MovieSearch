package com.example.moviesearch.AdaptersItems

import android.annotation.SuppressLint
import com.example.moviesearch.model.FilmDataClass
import com.example.moviesearch.Interfaces.RecyclerViewItems
import com.example.moviesearch.Activitys.MainActivity
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class FilmAdapter(requireActivity: MainActivity) : ListDelegationAdapter<List<RecyclerViewItems>>() {
    init {
        delegatesManager.addDelegate(FilmDelegateAdapter(object :
            FilmDelegateAdapter.OnItemClickListener {
            override fun click(film: FilmDataClass) {
                (requireActivity).launchDetailsFragment(film)
            }
        }))
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setItems(items: List<RecyclerViewItems>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}