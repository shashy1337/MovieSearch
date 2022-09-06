package com.example.moviesearch.AdaptersItems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.model.FilmDataClass
import com.example.moviesearch.Interfaces.RecyclerViewItems
import com.example.moviesearch.R
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class FilmDelegateAdapter(private val clickListener: OnItemClickListener)
    : AbsListItemAdapterDelegate<FilmDataClass, RecyclerViewItems, FilmDelegateAdapter.FilmViewHolder>() {


    class FilmViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val poster : ImageView = view.findViewById(R.id.poster)
        private val title : TextView = view.findViewById(R.id.title)
        private val description : TextView = view.findViewById(R.id.description)

        fun bind(film: FilmDataClass){
            title.text = film.title
            poster.setImageResource(film.poster)
            description.text = film.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup): FilmViewHolder {
        return FilmViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.film_item, parent, false))
    }

    override fun isForViewType(
        item: RecyclerViewItems,
        items: MutableList<RecyclerViewItems>,
        position: Int
    ): Boolean {
        return item is FilmDataClass
    }

    override fun onBindViewHolder(
        item: FilmDataClass,
        holder: FilmViewHolder,
        payloads: MutableList<Any>
    ) {
        when(holder){
            else -> {
                holder.bind(item)
                holder.itemView.findViewById<CardView>(R.id.item_container).setOnClickListener {
                    clickListener.click(item)
                }
            }
        }
    }

    interface OnItemClickListener {

        fun click(film : FilmDataClass)

    }

}

