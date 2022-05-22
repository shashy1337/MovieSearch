package com.example.moviesearch.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.FilmDataClass
import com.example.moviesearch.R

class FilmAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>(){

    val filmList = mutableListOf<FilmDataClass>()

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false))
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        when(holder){
            is FilmViewHolder -> {
                holder.bind(filmList[position])

                holder.itemView.findViewById<CardView>(R.id.item_container).setOnClickListener {
                    clickListener.click(filmList[position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(films : List<FilmDataClass>){
        filmList.clear()
        filmList.addAll(films)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {

        fun click(film : FilmDataClass)

    }

}

