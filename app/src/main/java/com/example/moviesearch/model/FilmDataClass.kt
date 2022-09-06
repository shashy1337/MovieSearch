package com.example.moviesearch.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.moviesearch.Interfaces.RecyclerViewItems
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmDataClass
    (val title : String, @DrawableRes val poster : Int, val description : String, var isFavourite : Boolean = false)
    : Parcelable, RecyclerViewItems
