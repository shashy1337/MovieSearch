package com.example.moviesearch

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.moviesearch.AdaptersItems.RecyclerViewItems
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmDataClass(val title : String, @DrawableRes val poster : Int, val description : String)
    : Parcelable, RecyclerViewItems
