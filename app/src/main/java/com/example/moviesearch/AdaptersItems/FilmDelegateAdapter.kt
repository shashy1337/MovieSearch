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
import com.example.moviesearch.databinding.FilmItemBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.synthetic.main.film_item.view.*

class FilmDelegateAdapter(private val clickListener: OnItemClickListener)
    : AbsListItemAdapterDelegate<FilmDataClass, RecyclerViewItems, FilmDelegateAdapter.FilmViewHolder>() {

    private lateinit var binding: FilmItemBinding

    class FilmViewHolder(binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root){
        private val poster : ImageView = binding.poster
        private val title : TextView = binding.title
        private val description : TextView = binding.description

        fun bind(film: FilmDataClass){
            title.text = film.title
            poster.setImageResource(film.poster)
            description.text = film.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup): FilmViewHolder {
        binding = FilmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
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
                holder.itemView.item_container.setOnClickListener {
                    clickListener.click(item)
                }
            }
        }
    }

    interface OnItemClickListener {

        fun click(film : FilmDataClass)

    }

}

